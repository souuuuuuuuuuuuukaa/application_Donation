package com.example.userms;

import com.example.userms.Entity.Users;
import com.example.userms.Repositoris.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UsermsApplication implements CommandLineRunner {
    private UserRepo userRepo;
    public static void main(String[] args) {
        SpringApplication.run(UsermsApplication.class, args);
    }

    public  UsermsApplication(UserRepo userRepo){
        this.userRepo=userRepo;
    }
    @Override
    public void run(String... args) throws Exception {
        userRepo.save(new Users(1,"nom1" ,"PRENOM1" ,"Email1@gmail.com" )) ;
        userRepo.save(new Users(2,"nom2" ,"PRENOM22" ,"EMAIL2@gmail.com" )) ;
        userRepo.save(new Users(3,"nom3" ,"PRENOM3" ,"EMAIL3@gmail.com" )) ;
        userRepo.save(new Users(4,"nom4" ,"PRENOM4" ,"EMAIL4@gmail.com" )) ;
        userRepo.save(new Users(5,"nom5" ,"PRENOM5" ,"EMAIL5@gmail.com" )) ;
    }
}