package com.shoppingCartBe.controllers;

import java.net.URI;
import java.util.Collections;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.BeanIds;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.shoppingCartBe.exception.AppException;
import com.shoppingCartBe.models.Role;
import com.shoppingCartBe.models.RoleName;
import com.shoppingCartBe.models.User;
import com.shoppingCartBe.payload.ApiResponse;
import com.shoppingCartBe.payload.JwtAuthenticationResponse;
import com.shoppingCartBe.payload.LoginRequest;
import com.shoppingCartBe.payload.SignUpRequest;
import com.shoppingCartBe.repositories.RoleRepository;
import com.shoppingCartBe.repositories.UserRepository;
import com.shoppingCartBe.security.JwtAuthenticationFilter;
import com.shoppingCartBe.security.JwtTokenProvider;
import com.shoppingCartBe.security.UserPrincipal;
import com.shoppingCartBe.services.NextSequenceNumber;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
    AuthenticationManager authenticationManager;
	
	@Autowired
	private NextSequenceNumber nextSequenceNumber;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;
    
//    @Bean
//    public AuthenticationManager authenticationManager() {
//        return new AuthenticationManager();
//    }
    
	
	@PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );
        
        System.out.println(authentication.getPrincipal());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        
        //User user = userRepository.findByUsername(userPrincipal.getUsername());

        

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt, userPrincipal));
    }
	
	@PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User user = new User(signUpRequest.getName(), signUpRequest.getUsername(),
                signUpRequest.getEmail(), signUpRequest.getPassword(), signUpRequest.getUsername());

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setPlainPassword(user.getPassword());
        
        System.out.println("RoleName.ROLE_USER ---"+RoleName.ROLE_USER);

        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new AppException("User Role not set."));
        
        //Role userRole = roleRepository.findByName("user").orElseThrow(() -> new AppException("User Role not set."));;

        user.setRoles(Collections.singleton(userRole));
        user.setUserID(nextSequenceNumber.getNextSequence(User.SEQUENCE_NAME));

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }

}
