package org.bphc.RideShare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Calendar;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String price;
    private String source;
    private String destination;
    private String date;
    private String time;
    private Integer capacity;
    private String otp;
    @Column(name = "driver_id")
    private Long driverId;
}
