package com.example.donation.Controller;

import com.example.donation.Entity.Donation;
import com.example.donation.Repositories.DonRepo;
import com.example.donation.Services.OrgRestClient;
import com.example.donation.Services.UserRestClient;
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
    @Autowired
    private UserRestClient userRestClient;
    @Autowired
    private OrgRestClient orgRestClient;

    // Get all donations
    @GetMapping("/listdon")
    public List<Donation> getAllDonations() {
        return donationRep.findAll();
    }

    @PostMapping("createdon")
    public Donation createDonation(@RequestBody Donation donation) {
        return donationRep.save(donation);
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

    @GetMapping("/donations")
    public Donation getDonation(@PathVariable Long id){
        Donation donation=donationRep.findById(id).get();
        donation.setUser(userRestClient.getUserById(donation.getId()));
        donation.setOrganisation(orgRestClient.getOrganisationById(donation.getId()));
        return donation;
    }
}
