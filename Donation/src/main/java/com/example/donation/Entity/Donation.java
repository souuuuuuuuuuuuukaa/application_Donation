package com.example.donation.Entity;

import com.example.donation.Models.Organisation_mo;
import com.example.donation.Models.User_mo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Automatically generates a unique ID
    private Long id;
    private String donor;  // Name of the donor
    private int amount; // Amount donated

    @Transient
    private Organisation_mo organisation;
    @Transient
    private User_mo user;

    }
