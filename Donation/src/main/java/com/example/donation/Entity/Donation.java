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
@Data
@Builder
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long organisationId;
    private Double amount;
    @Transient
    private Organisation_mo org;
    @Transient
    private User_mo user;
}

