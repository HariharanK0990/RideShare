package org.bphc.RideShare.service;

import lombok.AllArgsConstructor;
import org.bphc.RideShare.dto.user.CreateUserDto;
import org.bphc.RideShare.dto.user.DriverSignInDto;
import org.bphc.RideShare.dto.user.SignInDto;
import org.bphc.RideShare.entity.Drivers;
import org.bphc.RideShare.entity.Users;
import org.bphc.RideShare.repository.DriversRepository;
import org.bphc.RideShare.repository.UsersRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SignIn {
    private UsersRepository usersRepository;
    private DriversRepository driversRepository;

    public Long signInUser(SignInDto signInDto) {
        Users user = usersRepository.findByUserName(signInDto.getPhoneNo(), signInDto.getPassword());
        return user.getId();
    }

    public Long signInDriver(DriverSignInDto driverSignInDto){
        Drivers drivers = driversRepository.findByUserName(driverSignInDto.getPhoneNo(),driverSignInDto.getPassword());
        return drivers.getId();
    }

    public Users getUserProfile(Long id){
        return usersRepository.findByUserId(id);
    }
}
