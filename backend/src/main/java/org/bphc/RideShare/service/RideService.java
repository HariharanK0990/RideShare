package org.bphc.RideShare.service;

import lombok.AllArgsConstructor;
import org.bphc.RideShare.dto.Mapper;
import org.bphc.RideShare.dto.ride.JoinRideDto;
import org.bphc.RideShare.dto.ride.SearchRideDto;
import org.bphc.RideShare.dto.user.CreateRideDto;
import org.bphc.RideShare.entity.Ride;
import org.bphc.RideShare.entity.UserRideKey;
import org.bphc.RideShare.repository.RideRepository;
import org.bphc.RideShare.repository.UserRiderKeyRepository;
import org.bphc.RideShare.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Service
public class RideService {
    UsersRepository usersRepository;
    RideRepository rideRepository;
    UserRiderKeyRepository userRiderKeyRepository;

    public Boolean createRide(CreateRideDto createRideDto){
        Ride ride = Mapper.mapToRide(createRideDto);
        ride.setCapacity(1);
        Random random = new Random();
        String otp = String.format("%04d", random.nextInt(10000));
        ride.setOtp(otp);
        ride = rideRepository.save(ride);
        UserRideKey userRideKey = new UserRideKey();
        userRideKey.setUserId(Long.parseLong(createRideDto.getUserId()));
        userRideKey.setRideId(ride.getId());
        userRideKey.setHost(true);
        userRiderKeyRepository.save(userRideKey);

        return true;
    };

    public Boolean joinRide(JoinRideDto joinRideDto) throws Exception{
        Ride ride = rideRepository.getRideById(Long.parseLong(joinRideDto.getRideId()));
        if(userRiderKeyRepository.checkIfUserIsInRide(Long.parseLong(joinRideDto.getUserId()),Long.parseLong(joinRideDto.getRideId())) > 0){
            throw new Exception("Already in this ride");
        }
        if(ride.getCapacity() > 4){
            throw new Exception("Above capacity");
        }
        ride.setCapacity(ride.getCapacity()+1);
        rideRepository.save(ride);
        UserRideKey userRideKey = new UserRideKey();
        userRideKey.setHost(false);
        userRideKey.setUserId(Long.parseLong(joinRideDto.getUserId()));
        userRideKey.setRideId(Long.parseLong(joinRideDto.getRideId()));
        userRiderKeyRepository.save(userRideKey);

        return true;
    }

    public List<UserRideKey> getRides(Long id){
        return userRiderKeyRepository.getRidesByUser(id);
    }

    public List<Long> getAllRides(){
        return rideRepository.getAllRides();
    }

    public Ride getRideDetails(Long id){
        return rideRepository.getRideById(id);
    }

    public List<Long> getRidesBySearch(SearchRideDto searchRideDto){
        return rideRepository.getRidesBySearch(searchRideDto.getSource(),searchRideDto.getDestination(),searchRideDto.getDate());
    }
}
