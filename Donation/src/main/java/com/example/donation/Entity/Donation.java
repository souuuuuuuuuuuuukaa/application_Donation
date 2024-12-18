package com.example.donation.Entity;

import com.example.donation.Models.Organisation_mo;
import com.example.donation.Models.User_mo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Long organisationId;
    @Transient
    private Organisation_mo org;
    @OneToMany(mappedBy = "don",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<UserDonation> userDonations=new ArrayList<>();

}

