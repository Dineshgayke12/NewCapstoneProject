package com.in.User.com.in.User.Services;


import com.in.User.com.in.User.DTO.signUpRequest;
import com.in.User.com.in.User.Entities.User;
import com.in.User.com.in.User.Repositories.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthServices {

    private final UserRepo userRepo;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean createCostumer(signUpRequest signupRequest) {

        if (userRepo.existsByEmail(signupRequest.getEmail())) {
            return false;
        }

        User user = new User();
        BeanUtils.copyProperties(signupRequest, user);

//        ***********Above mehod equal to all this below ************
//        user.setEmail(signupRequest.getEmail());
//        user.setName(signupRequest.getName());
//        user.setPassword(signupRequest.getPassword());
//        *************************Ends***************


//      Hash the passwod before saving
        String hashPassword=passwordEncoder.encode(signupRequest.getPassword());
        user.setPassword(hashPassword);
        userRepo.save(user);

        return true;
    }
}
