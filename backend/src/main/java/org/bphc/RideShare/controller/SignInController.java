package org.bphc.RideShare.controller;

import lombok.AllArgsConstructor;
import org.bphc.RideShare.dto.user.DriverSignInDto;
import org.bphc.RideShare.dto.user.SignInDto;
import org.bphc.RideShare.entity.Users;
import org.bphc.RideShare.repository.UsersRepository;
import org.bphc.RideShare.service.SignIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
@RestController
@RequestMapping("/api/signin")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SignInController {
    SignIn signIn;

    @PostMapping("/users")
    public ResponseEntity<Long> userSignIn(@RequestBody SignInDto signInDto){
        try {
            return new ResponseEntity<Long>(signIn.signInUser(signInDto), HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Invalid user");
        }
    }
    @PostMapping("/drivers")
    public ResponseEntity<Long> driverSignIn(@RequestBody DriverSignInDto driverSignInDto){
        try {
            return new ResponseEntity<Long>(signIn.signInDriver(driverSignInDto), HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Invalid user");
        }
    }



    @GetMapping("/userprofile/{id}")
    public ResponseEntity<Users> getUserProfile(@PathVariable("id") Long id){
        try {
            return new ResponseEntity<Users>(signIn.getUserProfile(id),HttpStatus.OK);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,e.getMessage());
        }
    }
}
