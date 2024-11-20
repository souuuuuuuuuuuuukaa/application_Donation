package com.example.org_ms.Repository;

import com.example.org_ms.Entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrgRepo extends JpaRepository<Organization,Long> {
}
