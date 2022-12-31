package com.back_end_android.back_end.controllers;

import com.back_end_android.back_end.models.User;
import com.back_end_android.back_end.models.WhishList;
import com.back_end_android.back_end.repository.UserRepository;
import com.back_end_android.back_end.security.jwt.JwtUtils;
import com.back_end_android.back_end.service.ServiceDetailsGame;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import io.jsonwebtoken.security.Keys;



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


    @GetMapping("/all/whishlist")
    @PreAuthorize("hasRole('USER')")
    public List<WhishList> list(HttpServletRequest request ){
        String name = decodeName(request.getHeader("Authorization"));
        return serviceDetailsGame.listWhishlist(name, "whishlist");


    }

    @PostMapping("/save/whishlist/{id}")
    @PreAuthorize("hasRole('USER')")
    public WhishList save(@PathVariable int id, HttpServletRequest request ) throws IOException {
        String name = decodeName(request.getHeader("Authorization"));
        return serviceDetailsGame.save(name, id, "whishlist");

    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('USER')")
    public void delete(@PathVariable String id){
        serviceDetailsGame.delete(id);
    }


    @GetMapping("/all/likelist")
    @PreAuthorize("hasRole('USER')")
    public List<WhishList> listLike(HttpServletRequest request ){
        String name = decodeName(request.getHeader("Authorization"));
        return serviceDetailsGame.listWhishlist(name, "like");


    }

    @PostMapping("/save/like/{id}")
    @PreAuthorize("hasRole('USER')")
    public WhishList saveLike(@PathVariable int id, HttpServletRequest request ) throws IOException {
        String name = decodeName(request.getHeader("Authorization"));
        return serviceDetailsGame.save(name, id, "like");

    }


    private  String decodeName(String encodedString) {
        String[] jwtDetails = encodedString.split(" ");
        return jwtUtils.getUserNameFromJwtToken(jwtDetails[1]);
    }

}
