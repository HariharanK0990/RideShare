package org.bphc.RideShare.service;


import lombok.AllArgsConstructor;
import org.bphc.RideShare.entity.Drivers;
import org.bphc.RideShare.entity.Messages;
import org.bphc.RideShare.entity.Ride;
import org.bphc.RideShare.entity.Users;
import org.bphc.RideShare.repository.DriversRepository;
import org.bphc.RideShare.repository.MessageRepository;
import org.bphc.RideShare.repository.RideRepository;
import org.bphc.RideShare.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MessageService {
    MessageRepository messageRepository;
    DriversRepository driversRepository;
    UsersRepository usersRepository;
    RideRepository rideRepository;

    public boolean addUserMessage(String s,Long userId,Long rideId){
        Users users = usersRepository.getReferenceById(userId);
        s = users.getName() + ": " + s;
        Messages messages = new Messages();
        messages.setMessage(s);
        messages.setRideId(rideId);
        messageRepository.save(messages);
        return true;
    }
    public boolean addDriverMessage(String s,Long driverId,Long rideId){
        if(s.contains("OTP:")){
            Messages messages = new Messages();
            messages.setRideId(rideId);
            String otp = s.replace("OTP:","");
            Ride ride = rideRepository.getRideById(rideId);
            if(ride.getOtp().equals(otp)){
                messages.setMessage("System: Driver otp verified");
            }
            else {
                messages.setMessage("System: Wrong otp entered");
            }
            messageRepository.save(messages);
            return true;
        }
        Drivers drivers= driversRepository.getReferenceById(driverId);
        s = drivers.getName() + " (driver): " + s;
        Messages messages = new Messages();
        messages.setMessage(s);
        messages.setRideId(rideId);
        messageRepository.save(messages);
        return true;
    }

    public List<String> getRideMessages(Long rideId){
        return messageRepository.getMessagesByRide(rideId);
    }
}
