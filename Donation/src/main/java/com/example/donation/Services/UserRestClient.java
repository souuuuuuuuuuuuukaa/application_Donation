package com.example.donation.Services;

import com.example.donation.Models.User_mo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "users")
public interface UserRestClient {
    @GetMapping(path = "/Users/{id}")
    User_mo getUserById(@PathVariable Long id);
    @GetMapping(path = "/Users")
    List<User_mo> getUsers();
}
