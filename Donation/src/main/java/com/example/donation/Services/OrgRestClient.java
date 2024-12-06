package com.example.donation.Services;

import com.example.donation.Models.Organisation_mo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "Orgms")
public interface OrgRestClient {
    @GetMapping(path = "/orgs/{id}")
    Organisation_mo getOrganisationById(@PathVariable Long id);
    @GetMapping(path = "/orgs")
    List<Organisation_mo> getOrganisations();
}
