package org.bphc.RideShare.dto;

import org.bphc.RideShare.dto.ride.DriverDetailsDto;
import org.bphc.RideShare.dto.user.CreateDriverDto;
import org.bphc.RideShare.dto.user.CreateRideDto;
import org.bphc.RideShare.dto.user.CreateUserDto;
import org.bphc.RideShare.entity.Drivers;
import org.bphc.RideShare.entity.Ride;
import org.bphc.RideShare.entity.Users;

import java.util.Base64;

public class Mapper {

    public static Users mapToUsers(CreateUserDto createUserDto){
        Users users = new Users();
        users.setName(createUserDto.getName());
        users.setEmail(createUserDto.getEmail());
        users.setPassword(createUserDto.getPassword());
        users.setPhoneNo(createUserDto.getPhoneNo());
        users.setDp(createUserDto.getDp());
        return users;
    }

    public static Ride mapToRide(CreateRideDto createRideDto){
        Ride ride = new Ride();
        ride.setSource(createRideDto.getSource());
        ride.setPrice(createRideDto.getPrice());
        ride.setDestination(createRideDto.getDestination());
        ride.setDate(createRideDto.getDate());
        ride.setTime(createRideDto.getTime());
        return ride;
    }

    public static Drivers mapToDriver(CreateDriverDto createDriverDto){
        Drivers drivers = new Drivers();
        drivers.setName(createDriverDto.getName());
        drivers.setPhoneNo(createDriverDto.getPhoneNo());
        drivers.setPassword(createDriverDto.getPassword());
        drivers.setLicensePlate(createDriverDto.getLicensePlate());
        drivers.setEmail(createDriverDto.getEmail());
        drivers.setDp(createDriverDto.getDp());
        return drivers;
    }

    public static DriverDetailsDto mapToDriverDetails(Drivers drivers){
        DriverDetailsDto driverDetailsDto = new DriverDetailsDto();
        driverDetailsDto.setName(drivers.getName());
        driverDetailsDto.setLicensePlate(drivers.getLicensePlate());
        driverDetailsDto.setPhoneNo(drivers.getPhoneNo());
        driverDetailsDto.setDp(drivers.getDp());

        return driverDetailsDto;
    }
}
