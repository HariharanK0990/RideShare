package org.bphc.RideShare.dto.ride;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SearchRideDto {
    private String source;
    private String destination;
    private String date;
}
