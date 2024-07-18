package org.bphc.RideShare.service;

import lombok.AllArgsConstructor;
import org.bphc.RideShare.dto.Mapper;
import org.bphc.RideShare.dto.ride.DriverDetailsDto;
import org.bphc.RideShare.dto.user.DriverJoinRideDto;
import org.bphc.RideShare.entity.Drivers;
import org.bphc.RideShare.entity.Ride;
import org.bphc.RideShare.repository.DriversRepository;
import org.bphc.RideShare.repository.RideRepository;
import org.springframework.stereotype.Service;

import java.sql.Driver;
import java.util.List;


@AllArgsConstructor
@Service
public class DriverRideServices {
    RideRepository rideRepository;
    DriversRepository driversRepository;

    public Boolean joinRide(DriverJoinRideDto driverJoinRideDto) throws Exception{
        Ride ride = rideRepository.getRideById(driverJoinRideDto.getRideId());
        if(ride.getDriverId() != null){
            throw new Exception("Ride Already has a driver");
        }
        ride.setDriverId(driverJoinRideDto.getDriverId());
        rideRepository.save(ride);
        return true;
    }

    public List<Long> getRides(Long driverId){
        return rideRepository.getRidesByDriverId(driverId);
    }

    public DriverDetailsDto getDriverDetails(Long id){
        return Mapper.mapToDriverDetails(driversRepository.findByDriverId(id));
    }
}
