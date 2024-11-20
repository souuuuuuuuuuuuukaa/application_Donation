package com.example.donation;

import com.example.donation.Entity.Donation;
import com.example.donation.Repositories.DonRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DonationApplication implements CommandLineRunner {
    private DonRepo donRepo;

    public static void main(String[] args) {
        SpringApplication.run(DonationApplication.class, args);
    }

    public DonationApplication(DonRepo donRepo){
        this.donRepo=donRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        donRepo.save(new Donation(1L,"donor1",123));
        donRepo.save(new Donation(2L,"donor2",456));
        donRepo.save(new Donation(3L,"donor3",678));
        donRepo.save(new Donation(4L,"donor4",890));
        donRepo.save(new Donation(5L,"donor5",1011));

    }
}
