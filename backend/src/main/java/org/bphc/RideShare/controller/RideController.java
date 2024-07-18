package org.bphc.RideShare.controller;

import lombok.AllArgsConstructor;
import org.bphc.RideShare.dto.ride.JoinRideDto;
import org.bphc.RideShare.dto.ride.SearchRideDto;
import org.bphc.RideShare.dto.user.CreateRideDto;
import org.bphc.RideShare.entity.Ride;
import org.bphc.RideShare.entity.UserRideKey;
import org.bphc.RideShare.service.RideService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/ride")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RideController {
    RideService rideService;

    @PostMapping("/create")
    public ResponseEntity<Boolean> createRide(@RequestBody CreateRideDto createRideDto){
        try {
           return new ResponseEntity<Boolean>(rideService.createRide(createRideDto),HttpStatus.CREATED);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @PostMapping("/join")
    public ResponseEntity<Boolean> joinRide(@RequestBody JoinRideDto joinRideDto){
        try{

            return new ResponseEntity<Boolean>(rideService.joinRide(joinRideDto),HttpStatus.CREATED);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @GetMapping("/getMyRides/{id}")
    public ResponseEntity<List<UserRideKey>> getRides(@PathVariable("id") Long id){
        try {
            return new ResponseEntity<List<UserRideKey>>(rideService.getRides(id),HttpStatus.OK);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @GetMapping("/getAllRides")
    public ResponseEntity<List<Long>> getAllRides(){
        try {
            return new ResponseEntity<List<Long>>(rideService.getAllRides(), HttpStatus.OK);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @PostMapping("/getRidesBySearch")
    public ResponseEntity<List<Long>> getRidesBySearch(@RequestBody SearchRideDto searchRideDto){
        try {
            return new ResponseEntity<List<Long>>(rideService.getRidesBySearch(searchRideDto),HttpStatus.OK);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @GetMapping("/getRideDetails/{id}")
    public ResponseEntity<Ride> getRideDetails(@PathVariable("id") Long id){
        try {
            return new ResponseEntity<Ride>(rideService.getRideDetails(id),HttpStatus.OK);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }
}
