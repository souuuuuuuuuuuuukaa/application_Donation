package com.example.org_ms.Controller;

import com.example.org_ms.Entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.org_ms.Repository.OrgRepo;

import java.util.List;

@RestController
@RequestMapping("/organisations")
public class OrganController {

    @Autowired
    private OrgRepo organizationRepository;

    @GetMapping("/ListOrganisation")
    public List<Organization> getAllOrganisations() {
        return organizationRepository.findAll();
    }

    @PostMapping("createOrg")
    public Organization createOrganisation(@RequestBody Organization organization) {
        return organizationRepository.save(organization);
    }

    @GetMapping("/getOrganisationById/{id}")
    public Organization getOrganisationById(@PathVariable Long id) {
        return organizationRepository.findById(id).get();
    }

    @PutMapping("/Update/{id}")
    public Organization updateOrganisation(@PathVariable Long id, @RequestBody Organization organizationDetails) {
        Organization organization = organizationRepository.findById(id).get();
        organization.setName(organizationDetails.getName());
        organization.setAddress(organizationDetails.getAddress());
        return organizationRepository.save(organization);
    }
    @DeleteMapping("/deleteOrganisationById/{id}")
    public void deleteOrganisationById(@PathVariable Long id){
        organizationRepository.deleteById(id);
    }


}

