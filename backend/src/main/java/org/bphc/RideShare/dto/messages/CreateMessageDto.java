package org.bphc.RideShare.dto.messages;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateMessageDto {
    String message;
    String rideId;
    String userId;
}
