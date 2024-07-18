package org.bphc.RideShare.dto.user;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class CreateRideDto {
    private String userId;
    private String price;
    private String source;
    private String destination;
    private String date;
    private String time;
}
