package org.bphc.RideShare.dto.ride;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DriverDetailsDto {
    private String name;
    private String phoneNo;
    private String licensePlate;
    private String dp;
}
