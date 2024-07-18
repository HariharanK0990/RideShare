package org.bphc.RideShare.service;

import org.bphc.RideShare.dto.Mapper;
import org.bphc.RideShare.dto.user.CreateDriverDto;
import org.bphc.RideShare.dto.user.CreateUserDto;
import lombok.AllArgsConstructor;
import org.bphc.RideShare.entity.Drivers;
import org.bphc.RideShare.entity.Users;
import org.bphc.RideShare.repository.DriversRepository;
import org.bphc.RideShare.repository.UsersRepository;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class SignUp {

    private UsersRepository usersRepository;
    private DriversRepository driversRepository;

    public Boolean createUser(CreateUserDto createUserDto){
        Users users = Mapper.mapToUsers(createUserDto);
        usersRepository.save(users);
        return true;
    }

    public Boolean createDriver(CreateDriverDto createDriverDto){
        Drivers drivers = Mapper.mapToDriver(createDriverDto);
        driversRepository.save(drivers);
        return true;
    }
}
