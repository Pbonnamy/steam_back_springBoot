package com.back_end_android.back_end.controllers;

import com.back_end_android.back_end.models.responseRetrofit.GameDetails;
import com.back_end_android.back_end.models.responseRetrofit.ReviewEntityReponse;
import com.back_end_android.back_end.payload.response.MessageResponse;
import com.back_end_android.back_end.security.jwt.JwtUtils;
import com.back_end_android.back_end.service.ServiceDetailsGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/steam")
public class SteamController {



    @Autowired
    private ServiceDetailsGame serviceDetailsGame;

    @GetMapping("/GetMostPlayedGames/{country}/{start}/{finish}")
    public ResponseEntity<?> mostPlayedGames(@PathVariable String  country,
                                             @PathVariable int start,
                                             @PathVariable int finish) throws IOException {
        List<GameDetails> gameDetails = serviceDetailsGame.listRanking(country, start, finish);
        if (gameDetails==null || gameDetails.isEmpty()) return  ResponseEntity.badRequest().body(new MessageResponse("Request don't finish"));
        return ResponseEntity.ok(gameDetails);
    }

    @GetMapping("/details/{id}/{country}")
    public  ResponseEntity<?> detailGame(@PathVariable int id, @PathVariable String  country) throws IOException {
        GameDetails gameDetails = serviceDetailsGame.setGame(id, country);
        if (gameDetails==null) return  ResponseEntity.badRequest().body(new MessageResponse("Request don't finish"));
        return ResponseEntity.ok(gameDetails);
    }


    @GetMapping("/reviews/{id}/{start}/{finish}")
    public  ResponseEntity<?> reviewsList(@PathVariable int id, @PathVariable int start, @PathVariable int finish) throws IOException {
        List<ReviewEntityReponse> responseEntities = serviceDetailsGame.listReviewGame(id, start, finish);
        if (responseEntities == null) ResponseEntity.badRequest().body(new MessageResponse("Request don't finish"));
        return ResponseEntity.ok(responseEntities);
    }


    @GetMapping("/search/{name}")
    public ResponseEntity<?>  searchGame(@PathVariable String name) throws IOException {
        List<GameDetails> gameDetails = serviceDetailsGame.listSearch(name);
        if(gameDetails == null) ResponseEntity.badRequest().body(new MessageResponse("Request don't finish"));
        return ResponseEntity.ok(gameDetails);
    }



}
