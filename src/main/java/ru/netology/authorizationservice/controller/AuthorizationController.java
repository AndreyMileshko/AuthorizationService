package ru.netology.authorizationservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.authorizationservice.config.CustomerParameter;
import ru.netology.authorizationservice.models.Customer;
import ru.netology.authorizationservice.repository.Authorities;
import ru.netology.authorizationservice.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {
    final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@CustomerParameter Customer customer) {
        return service.getAuthorities(customer.getUser(), customer.getPassword());
    }
}