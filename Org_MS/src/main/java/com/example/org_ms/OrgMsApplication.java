package com.example.org_ms;

import com.example.org_ms.Entity.Organization;
import com.example.org_ms.Repository.OrgRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrgMsApplication implements CommandLineRunner {
    private OrgRepo orgRepo;
    public static void main(String[] args) {
        SpringApplication.run(OrgMsApplication.class, args);
    }
    public OrgMsApplication(OrgRepo orgRepo){
        this.orgRepo=orgRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        orgRepo.save(new Organization(1,"organisation1","Adress1"));
        orgRepo.save(new Organization(2,"organisation2","Adress12"));
        orgRepo.save(new Organization(3,"organisation3","Adress13"));
        orgRepo.save(new Organization(4,"organisation4","Adress14"));
        orgRepo.save(new Organization(5,"organisation5","Adress15"));
        orgRepo.save(new Organization(6,"organisation6","Adress16"));
        orgRepo.save(new Organization(7,"organisation7","Adress17"));
    }
}
