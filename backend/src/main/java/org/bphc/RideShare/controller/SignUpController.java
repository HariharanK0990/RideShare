package org.bphc.RideShare.controller;

import org.bphc.RideShare.dto.user.CreateDriverDto;
import org.bphc.RideShare.dto.user.CreateUserDto;
import lombok.AllArgsConstructor;
import org.bphc.RideShare.service.SignUp;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;


@AllArgsConstructor
@RestController
@RequestMapping("/api/signup")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SignUpController {
    private SignUp signUp;

    //sign up for user
    @PostMapping("/users")
    public ResponseEntity<Boolean> userSignUp(@RequestBody CreateUserDto createUserDto) throws Exception{
        try {
            return new ResponseEntity<Boolean>(signUp.createUser(createUserDto), HttpStatus.CREATED);
        }
        catch(Exception ex) {
            if (ex.getMessage().contains("unique constraint")) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Phone no already exists");
            }
        }
        return new ResponseEntity<Boolean>(false,HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/drivers")
    public ResponseEntity<Boolean> driverSignUp(@RequestBody CreateDriverDto createDriverDto) throws Exception{
        try {
            return new ResponseEntity<Boolean>(signUp.createDriver(createDriverDto), HttpStatus.CREATED);
        }
        catch(Exception ex) {
            if (ex.getMessage().contains("unique constraint")) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Phone no already exists");
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
            }
        }
    }
}
