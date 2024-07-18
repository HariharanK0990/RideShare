package org.bphc.RideShare.controller;

import lombok.AllArgsConstructor;
import org.bphc.RideShare.dto.ride.DriverDetailsDto;
import org.bphc.RideShare.dto.user.DriverJoinRideDto;
import org.bphc.RideShare.entity.Drivers;
import org.bphc.RideShare.entity.Ride;
import org.bphc.RideShare.service.DriverRideServices;
import org.bphc.RideShare.service.RideService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Driver;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/driver/ride")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DriverRideController {
    DriverRideServices driverRideServices;

    @GetMapping("/myrides/{id}")
    public ResponseEntity<List<Long>> getMyRides(@PathVariable("id") Long id){
        try {
            return new ResponseEntity<List<Long>>(driverRideServices.getRides(id), HttpStatus.OK);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @PostMapping("/joinride")
    public ResponseEntity<Boolean> joinRide(@RequestBody DriverJoinRideDto driverJoinRideDto){
        try {
            return new ResponseEntity<Boolean>(driverRideServices.joinRide(driverJoinRideDto),HttpStatus.OK);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @GetMapping("/driverdetails/{id}")
    public ResponseEntity<DriverDetailsDto> joinRide(@PathVariable("id") Long id){
        try {
            return new ResponseEntity<DriverDetailsDto>(driverRideServices.getDriverDetails(id),HttpStatus.OK);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }
}
