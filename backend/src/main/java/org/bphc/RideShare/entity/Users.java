package org.bphc.RideShare.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "phone_no",nullable = false,unique = true)
    private String phoneNo;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Lob
    @Column(name = "dp",columnDefinition="TEXT")
    private String dp;
}
