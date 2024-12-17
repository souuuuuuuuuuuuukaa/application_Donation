package com.example.donation.Services;

import com.example.donation.Models.Organisation_mo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "Orgms")
public interface OrgRestClient {
    @GetMapping(path = "/organisations/getOrganisationById/{id}")
    Organisation_mo getOrganisationById(@PathVariable long id);
    @GetMapping(path = "/organisations/ListOrganisation")
    List<Organisation_mo> getAllOrganisations();
}
