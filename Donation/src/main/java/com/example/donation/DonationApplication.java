package com.example.donation;

import com.example.donation.Repositories.DonRepo;
import com.example.donation.Services.OrgRestClient;
import com.example.donation.Services.UserRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

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
        /*donRepo.save(new Donation(1L,"donor1",123));
        donRepo.save(new Donation(2L,"donor2",456));
        donRepo.save(new Donation(3L,"donor3",678));
        donRepo.save(new Donation(4L,"donor4",890));
        donRepo.save(new Donation(5L,"donor5",1011));
    */


    }
}
