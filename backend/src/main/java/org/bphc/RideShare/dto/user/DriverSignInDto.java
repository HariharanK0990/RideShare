package org.bphc.RideShare.dto.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DriverSignInDto {
    private String phoneNo;
    private String password;
}
