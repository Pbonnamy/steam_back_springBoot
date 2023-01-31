package com.back_end_android.back_end.controllers;

import com.back_end_android.back_end.models.WhishList;
import com.back_end_android.back_end.payload.response.MessageResponse;
import com.back_end_android.back_end.repository.UserRepository;
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
@RequestMapping("/api/list")
public class ListController {
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ServiceDetailsGame serviceDetailsGame;


    @GetMapping("/all/wishlist")
    @PreAuthorize("hasRole('USER')")
    public List<WhishList> list(HttpServletRequest request) {
        String email = decodeEmail(request.getHeader("Authorization"));
        return serviceDetailsGame.listWhishlist(email, "whishlist");


    }

    @PostMapping("/save/wishlist/{id}/{countryCode}")
    @PreAuthorize("hasRole('USER')")
    public WhishList save(@PathVariable int id,@PathVariable String countryCode,  HttpServletRequest request) throws IOException {
        String email = decodeEmail(request.getHeader("Authorization"));
        WhishList whishList = serviceDetailsGame.save(email,countryCode,  id, "whishlist");
        if (whishList == null) ResponseEntity.badRequest().body(new MessageResponse("The game exist in your list"));
        return ResponseEntity.ok(whishList).getBody();

    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('USER')")
    public void delete(@PathVariable String id) {
        serviceDetailsGame.delete(id);
    }


    @GetMapping("/all/likelist")
    @PreAuthorize("hasRole('USER')")
    public List<WhishList> listLike(HttpServletRequest request) {
        String email = decodeEmail(request.getHeader("Authorization"));
        return serviceDetailsGame.listWhishlist(email, "like");


    }

    @PostMapping("/save/like/{id}/{countryCode}")
    @PreAuthorize("hasRole('USER')")
    public WhishList saveLike(@PathVariable int id, @PathVariable String countryCode,  HttpServletRequest request) throws IOException {
        String email = decodeEmail(request.getHeader("Authorization"));
        WhishList like = serviceDetailsGame.save(email,countryCode,  id, "like");
        if (like == null) ResponseEntity.badRequest().body(new MessageResponse("The game exist in your list"));
        return ResponseEntity.ok(like).getBody();

    }


    private String decodeEmail(String encodedString) {
        String[] jwtDetails = encodedString.split(" ");
        return jwtUtils.getUserNameFromJwtToken(jwtDetails[1]);
    }

}
