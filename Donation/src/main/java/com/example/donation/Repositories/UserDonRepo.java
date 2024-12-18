package com.example.donation.Repositories;


import com.example.donation.Entity.UserDonation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserDonRepo extends JpaRepository<UserDonation, Long> {
}
