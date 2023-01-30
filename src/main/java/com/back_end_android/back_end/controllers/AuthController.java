package com.back_end_android.back_end.controllers;

import com.back_end_android.back_end.models.ERole;
import com.back_end_android.back_end.models.Role;
import com.back_end_android.back_end.models.User;
import com.back_end_android.back_end.payload.request.LoginRequest;
import com.back_end_android.back_end.payload.request.LostRequest;
import com.back_end_android.back_end.repository.RoleRepository;
import com.back_end_android.back_end.repository.UserRepository;
import com.back_end_android.back_end.security.services.UserDetailsImpl;
import com.back_end_android.back_end.payload.request.SignupRequest;
import com.back_end_android.back_end.payload.response.JwtResponse;
import com.back_end_android.back_end.payload.response.MessageResponse;
import com.back_end_android.back_end.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Value("${android.app.default_password}")
    private String passwordModify;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;


    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Validated @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("/signup/{cc}")
    public ResponseEntity<?> registerUser(@Validated @RequestBody SignupRequest signUpRequest,@PathVariable("cc") String cc ) {
        Map<String, List<String>> language = new HashMap<>();
        List<String> languagesFr = new ArrayList<>();
        languagesFr.add("Erreur: L'adresse email est déjà utilisée!");
        languagesFr.add("Erreur: Le nom de l'utilisateur est déjà utilisée!");
        languagesFr.add("Erreur: Le role n'est pas trouvé!");
        languagesFr.add("Erreur: Le role n'existe pas!");
        languagesFr.add("L'utilisateur c'est bien enregistrer !");
        languagesFr.add("Erreur: Le nom de l'utilisateur est trop grand (Maximum 20) ou trop petit (Minimum 3)!");
        languagesFr.add("Erreur: Password est trop petit (Minimum 6)!");
        languagesFr.add("Erreur: Email est trop grand (Maximum 50)!");
        List<String> languagesEn = new ArrayList<>();
        languagesEn.add("Error: Email is already in use!");
        languagesEn.add("Error: Username is already in use!");
        languagesEn.add("Error: Role is not found.");
        languagesEn.add("Error: Role is not found.");
        languagesEn.add("User registered successfully!");
        languagesEn.add("Error: Username is too long (Maximum 20) or too short (Minimum 3)!");
        languagesEn.add("Error: Password   too short (Minimum 6)!");
        languagesEn.add("Error: Email   too long (Maixmum 50)!");
        language.put("fr", languagesFr);
        language.put("en", languagesEn);
        if(signUpRequest.getUsername().length() < 3 || signUpRequest.getUsername().length() >= 20){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(language.get(cc).get(5)));
        }
        if(signUpRequest.getPassword().length() <= 6 ){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(language.get(cc).get(7)));
        }
        if(signUpRequest.getEmail().length() > 50){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(language.get(cc).get(0)));
        }

        if (userRepository.existsByUsername(signUpRequest.getUsername())) {

            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(language.get(cc).get(1)));
        }
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(language.get(cc).get(0)));
        }

        String password = encoder.encode(signUpRequest.getPassword());
        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                password
                );

        Set<String> strRoles = signUpRequest.getRoles();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException(language.get(cc).get(2)));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException(language.get(cc).get(2)));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse(language.get(cc).get(4)));
    }

    @PostMapping("/lost")
    public ResponseEntity<?> findLostPassword(@Validated @RequestBody LostRequest lostRequest){
        if (!userRepository.existsByEmail(lostRequest.getEmail())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email doesn't exist"));
        }
        Optional<User> user = userRepository.findByEmail(lostRequest.getEmail());
        User userSave= user.get();
        userSave.setPassword(encoder.encode(passwordModify));
        userRepository.save(userSave);
        return ResponseEntity.ok().body(new MessageResponse("Password change default"));
    }

}

