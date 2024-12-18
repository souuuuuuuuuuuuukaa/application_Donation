package com.example.donation;

import com.example.donation.Entity.Donation;
import com.example.donation.Entity.UserDonation;
import com.example.donation.Models.Organisation_mo;
import com.example.donation.Models.User_mo;
import com.example.donation.Repositories.DonRepo;
import com.example.donation.Repositories.UserDonRepo;
import com.example.donation.Services.OrgRestClient;
import com.example.donation.Services.UserRestClient;
import feign.FeignException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.time.LocalDate;


@SpringBootApplication
@EnableFeignClients
public class DonationApplication implements CommandLineRunner {
     @Autowired
     private DonRepo donRepo;
     @Autowired
     private UserRestClient userRestClient;
     @Autowired
     private OrgRestClient orgRestClient;
     @Autowired
     private UserDonRepo userDonRepo;

    public static void main(String[] args) {
        SpringApplication.run(DonationApplication.class, args);
    }

    public DonationApplication(DonRepo donRepo,UserRestClient userRestClient,OrgRestClient orgRestClient,UserDonRepo userDonRepo){
        this.donRepo=donRepo;
        this.userRestClient=userRestClient;
        this.orgRestClient=orgRestClient;
        this.userDonRepo=userDonRepo;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Sample data initialization
    /*    Donation donation = new Donation();
        donation.setUserId(1L);
        donation.setOrganisationId(2L);
        donation.setAmount(1520.0);

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
*/

        // Création d'une donation pour tester
        try {
            // Récupération de l'utilisateur depuis le service externe
            Long userId = 1L; // Utilisez l'ID de l'utilisateur que vous souhaitez tester
            User_mo user = userRestClient.getUserById(userId);
            if (user == null) {
                throw new IllegalArgumentException("Utilisateur avec ID " + userId + " introuvable.");
            }

            // Récupération de l'organisation depuis le service externe
            Long orgId = 2L; // Utilisez l'ID de l'organisation que vous souhaitez tester
            Organisation_mo organisation = orgRestClient.getOrganisationById(orgId);
            if (organisation == null) {
                throw new IllegalArgumentException("Organisation avec ID " + orgId + " introuvable.");
            }

            // Création de la donation
            Donation donation = new Donation();
            donation.setTitle("Nouveau don");
            donation.setDescription("Description du don");
            donation.setOrganisationId(orgId);
            donation.setOrg(organisation); // Associer l'organisation
            donation = donRepo.save(donation);

            // Création de la UserDonation
            UserDonation userDonation = new UserDonation();
            userDonation.setAmount(100.0);
            userDonation.setUserId(userId);
            userDonation.setDate(LocalDate.now());
            userDonation.setUser(user);
            userDonation.setDon(donation);

            // Sauvegarde de la UserDonation dans le repository
            userDonation= userDonRepo.save(userDonation);

            System.out.println("Donation sauvegardée : " + donation);
            System.out.println("UserDonation sauvegardé : " + userDonation);

        } catch (FeignException e) {
            System.err.println("Erreur lors de l'appel à un service via Feign : " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erreur lors de la gestion de la relation Donation-UserDonation : " + e.getMessage());
        }
    }

}
