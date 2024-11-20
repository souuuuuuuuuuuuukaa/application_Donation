package com.example.donation.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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



}
