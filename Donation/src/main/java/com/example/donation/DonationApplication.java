package com.example.donation;

import com.example.donation.Entity.Donation;
import com.example.donation.Models.Organisation_mo;
import com.example.donation.Models.User_mo;
import com.example.donation.Repositories.DonRepo;
import com.example.donation.Services.OrgRestClient;
import com.example.donation.Services.UserRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class DonationApplication implements CommandLineRunner {
     @Autowired
    private DonRepo donRepo;
     @Autowired
    UserRestClient userRestClient;
     @Autowired
     OrgRestClient orgRestClient;

    public static void main(String[] args) {
        SpringApplication.run(DonationApplication.class, args);
    }

    public DonationApplication(DonRepo donRepo,UserRestClient userRestClient,OrgRestClient orgRestClient){
        this.donRepo=donRepo;
        this.userRestClient=userRestClient;
        this.orgRestClient=orgRestClient;
    }

    @Override
    public void run(String... args) throws Exception {
        // Sample data initialization
        Donation donation = new Donation();
        donation.setUserId(1001L);
        donation.setOrganisationId(2001L);
        donation.setAmount(150.0);

        // Step 2: Fetch user and organisation details using Feign clients
        User_mo user = userRestClient.getUserById(donation.getUserId());
        Organisation_mo organisation = orgRestClient.getOrganisationById(donation.getOrganisationId());

        // Step 3: Associate the fetched user and organisation with the donation
        donation.setUser(user);
        donation.setOrg(organisation);

        // Step 4: Save the donation to the repository
        donRepo.save(donation);

        // Step 5: Print confirmation
        System.out.println("Donation successfully created and saved:");
        System.out.println("User: " + user.getNom());
        System.out.println("Organisation: " + organisation.getName());
        System.out.println("Amount: $" + donation.getAmount());


       /* User_mo user = userRestClient.getUserById(152L);
        Organisation_mo orga = orgRestClient.getOrganisationById(1L);
        Donation donation = donRepo.save(Donation.builder()
                .userId(user.getIdUSER())
                .organisationId(orga.getIdORG())
                .amount(100.0)
                .org(orga)
                .user(user)
                .build());*/
    }

}
