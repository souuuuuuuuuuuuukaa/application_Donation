package com.example.donation.Repositories;

import com.example.donation.Entity.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonRepo extends JpaRepository<Donation, Long> {
}
