package com.example.donation.Controller;

import com.example.donation.Entity.Donation;
import com.example.donation.Entity.UserDonation;
import com.example.donation.Repositories.DonRepo;
import com.example.donation.Repositories.UserDonRepo;
import com.example.donation.Services.OrgRestClient;
import com.example.donation.Services.UserRestClient;
import jakarta.validation.Valid;
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
    @Autowired
    private UserDonRepo userDonRepo;

    @GetMapping("/getAll")
    public List<Donation> getAllDonations() {
        return donationRep.findAll();
    }
    @GetMapping("/getDonationById/{id}")
    public Donation getDonationById(@PathVariable long id){
        Donation donation = donationRep.findById(id).get();
        UserDonation userDonation=userDonRepo.findById(id).get();
        userDonation.setUser(userRestClient.getUserById(userDonation.getUserId()));
        donation.setOrg(orgRestClient.getOrganisationById(donation.getOrganisationId()));
        return donation;
    }


  /*  @PostMapping
    public ResponseEntity<Donation> createDonation(@Valid @RequestBody Donation donation) {
        Donation savedDonation = donationRep.save(donation);
        return new ResponseEntity<>(savedDonation, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Donation> getDonationById(@PathVariable Long id) {
        Donation donation = donationRep.findById(id).orElseThrow(() -> new RuntimeException("Donation not found"));
        return new ResponseEntity<>(donation, HttpStatus.OK);
    }

    @PutMapping("/Update/{id}")
    public ResponseEntity<Donation> updateDonation(@PathVariable Long id, @Valid @RequestBody Donation donationDetails) {
        Donation donation = donationRep.findById(id).orElseThrow(() -> new RuntimeException("Donation not found"));
        donation.setAmount(donationDetails.getAmount());
        donation.setUserId(donationDetails.getUserId());
        donation.setOrganisationId(donationDetails.getOrganisationId());
        Donation updatedDonation = donationRep.save(donation);
        return new ResponseEntity<>(updatedDonation, HttpStatus.OK);
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<Donation> getDonationWithDetails(@PathVariable Long id) {
        Donation donation = donationRep.findById(id).orElseThrow(() -> new RuntimeException("Donation not found"));
        donation.setUser(userRestClient.getUserById(donation.getUserId()));
        donation.setOrg(orgRestClient.getOrganisationById(donation.getOrganisationId()));
        return new ResponseEntity<>(donation, HttpStatus.OK);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    */
}
