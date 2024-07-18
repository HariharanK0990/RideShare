package org.bphc.RideShare.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateDriverDto {
    private String name;
    private String phoneNo;
    private String password;
    private String email;
    private String licensePlate;
    private String dp;
}
