package com.back_end_android.back_end.controllers;

import com.back_end_android.back_end.models.GameDetailUp;
import com.back_end_android.back_end.models.WhishList;
import com.back_end_android.back_end.models.responseRetrofit.GameDetails;
import com.back_end_android.back_end.models.responseRetrofit.ReviewEntityReponse;
import com.back_end_android.back_end.payload.response.MessageResponse;
import com.back_end_android.back_end.repository.UserRepository;
import com.back_end_android.back_end.repository.WishlistRepository;
import com.back_end_android.back_end.security.jwt.JwtUtils;
import com.back_end_android.back_end.service.ServiceDetailsGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/steam")
public class SteamController {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ServiceDetailsGame serviceDetailsGame;

    @Autowired
    WishlistRepository wishlistRepository;


    @GetMapping("/GetMostPlayedGames/{country}/{start}/{finish}")
    public ResponseEntity<?> mostPlayedGames(@PathVariable String  country,
                                             @PathVariable int start,
                                             @PathVariable int finish) throws IOException {
        List<GameDetails> gameDetails = serviceDetailsGame.listRanking(country, start, finish);
        if (gameDetails==null || gameDetails.isEmpty()) return  ResponseEntity.badRequest().body(new MessageResponse("Request don't finish"));
        return ResponseEntity.ok(gameDetails);
    }

    @GetMapping("/details/{id}/{country}")
    @PreAuthorize("hasRole('USER')")
    public  ResponseEntity<?> detailGame(@PathVariable int id, @PathVariable String  country, HttpServletRequest request) throws IOException {
        String name = decodeName(request.getHeader("Authorization"));
        GameDetails gameDetails = serviceDetailsGame.setGame(id, country);
        userRepository.findByUsername(name);
        if (gameDetails==null) return  ResponseEntity.badRequest().body(new MessageResponse("Request don't finish"));
        List<WhishList> wishlist =  wishlistRepository.findByCountryCodeAndSteamIDAndType(country, id, "whishlist");
        Boolean isWish;
        Boolean isLike;
        if (wishlist.isEmpty()){
             isWish = false;
        }else{
             isWish = true;
        }
        List<WhishList>  like = wishlistRepository.findByCountryCodeAndSteamIDAndType(country, id, "like");
        if (like.isEmpty()){
            isLike = false;
        }else{
            isLike = true;
        }
        GameDetailUp gameDetailUp = new GameDetailUp(gameDetails, isWish, isLike);
        return ResponseEntity.ok(gameDetailUp);
    }


    @GetMapping("/reviews/{language}/{id}/{start}/{finish}")
    public  ResponseEntity<?> reviewsList(
            @PathVariable String language,
            @PathVariable int id,
            @PathVariable int start,
            @PathVariable int finish) throws IOException {
        List<ReviewEntityReponse> responseEntities = serviceDetailsGame.listReviewGame(language, id, start, finish);
        if (responseEntities == null) ResponseEntity.badRequest().body(new MessageResponse("Request don't finish"));
        return ResponseEntity.ok(responseEntities);
    }


    @GetMapping("/search/{countryCode}/{name}")
    public ResponseEntity<?>  searchGame(@PathVariable String name,@PathVariable String countryCode ) throws IOException {
        List<GameDetails> gameDetails = serviceDetailsGame.listSearch(name, countryCode);
        if(gameDetails == null) ResponseEntity.badRequest().body(new MessageResponse("Request don't finish"));
        return ResponseEntity.ok(gameDetails);
    }

    private String decodeName(String encodedString) {
        String[] jwtDetails = encodedString.split(" ");
        return jwtUtils.getUserNameFromJwtToken(jwtDetails[1]);
    }



}
