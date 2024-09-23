package com.in.User.com.in.User.Controllers;


import com.in.User.com.in.User.DTO.signUpRequest;
import com.in.User.com.in.User.Services.AuthServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/signup")
public class SignIUpController {
    private final AuthServices authService;

    @Autowired
    public SignIUpController(AuthServices authService) {
        this.authService = authService;
    }


    public ResponseEntity<String> signupUser(@RequestBody signUpRequest SignupRequest){
        boolean isUserCreated=authService.createCostumer(SignupRequest);

        if(isUserCreated){
            return  ResponseEntity.status(HttpStatus.CREATED).body("Customer created successfully");
        }

        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create USER");
        }
    }

}
