package com.example.donation.Controller;

import com.example.donation.Entity.Donation;
import com.example.donation.Repositories.DonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/donations")
public class DonationController {

    @Autowired
    private DonRepo donationRep;

    // Get all donations
    @GetMapping("/listdon")
    public List<Donation> getAllDonations() {
        return donationRep.findAll();
    }

    @PostMapping("createdon")
    public Donation createDonation(@RequestBody Donation Donation) {
        return donationRep.save(Donation);
    }

    @GetMapping("/{id}")
    public Donation getDonationById(@PathVariable Long id) {
        return donationRep.findById(id).get();
    }

    @PutMapping("/Updatedon/{id}")
    public Donation updateDonation(@PathVariable Long id, @RequestBody Donation DonationDetails) {
        Donation Donation = donationRep.findById(id).get();
        Donation.setDonor(DonationDetails.getDonor());
        Donation.setAmount(DonationDetails.getAmount());
        return donationRep.save(Donation);
    }
}
