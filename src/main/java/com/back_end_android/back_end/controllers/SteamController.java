package com.back_end_android.back_end.controllers;

import com.back_end_android.back_end.models.responseRetrofit.GameDetails;
import com.back_end_android.back_end.models.responseRetrofit.ReviewEntityReponse;
import com.back_end_android.back_end.payload.response.MessageResponse;
import com.back_end_android.back_end.repository.UserRepository;
import com.back_end_android.back_end.repository.WishlistRepository;
import com.back_end_android.back_end.security.jwt.JwtUtils;
import com.back_end_android.back_end.service.ServiceDetailsGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/steam")
@EnableCaching
public class SteamController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ServiceDetailsGame serviceDetailsGame;
    @Autowired
    WishlistRepository wishlistRepository;
    @Autowired
    private JwtUtils jwtUtils;




    @GetMapping("/GetMostPlayedGames/{country}/{start}/{finish}")
    @Cacheable("most")
    public ResponseEntity<?> mostPlayedGames(@PathVariable String country,
                                             @PathVariable int start,
                                             @PathVariable int finish) throws IOException {
        List<GameDetails> gameDetails = serviceDetailsGame.listRanking(country, start, finish);
        if (gameDetails == null || gameDetails.isEmpty())
            return ResponseEntity.badRequest().body(new MessageResponse("Request don't finish"));
        return ResponseEntity.ok(gameDetails);
    }

    @GetMapping("/details/{id}/{country}")
    @Cacheable("most2")
    public ResponseEntity<?> detailGame(@PathVariable int id, @PathVariable String country, HttpServletRequest request) throws IOException {
        return serviceDetailsGame.detailGameController(id, country);
    }

    @GetMapping("/details/user/game/{steamId}/{country}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> detailGameUser( @PathVariable String country, @PathVariable int steamId,  HttpServletRequest request) throws IOException {
        String email = decodeEmail(request.getHeader("Authorization"));
        return serviceDetailsGame.detailGameControllerUser( country,  email, steamId);
    }


    @GetMapping("/reviews/{language}/{id}/{start}/{finish}")
    @Cacheable("most3")
    public ResponseEntity<?> reviewsList(
            @PathVariable String language,
            @PathVariable int id,
            @PathVariable int start,
            @PathVariable int finish) throws IOException {
        List<ReviewEntityReponse> responseEntities = serviceDetailsGame.listReviewGame(language, id, start, finish);
        if (responseEntities == null) ResponseEntity.badRequest().body(new MessageResponse("Request don't finish"));
        return ResponseEntity.ok(responseEntities);
    }


    @GetMapping("/search/{countryCode}/{name}")
    @Cacheable("most4")
    public ResponseEntity<?> searchGame(@PathVariable String name, @PathVariable String countryCode) throws IOException {
        List<GameDetails> gameDetails = serviceDetailsGame.listSearch(name, countryCode);
        if (gameDetails == null) ResponseEntity.badRequest().body(new MessageResponse("Request don't finish"));
        return ResponseEntity.ok(gameDetails);
    }

    private String decodeEmail(String encodedString) {
        String[] jwtDetails = encodedString.split(" ");
        return jwtUtils.getUserNameFromJwtToken(jwtDetails[1]);
    }


}
