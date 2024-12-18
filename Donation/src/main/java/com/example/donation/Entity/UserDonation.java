package com.example.donation.Entity;

import com.example.donation.Models.User_mo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDonation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Automatically generates a unique ID
    long id;
    private Double amount;
    private Long userId;
    private LocalDate date;
    @Transient
    private User_mo user;
    @ManyToOne
    private Donation don;

}
