package ru.netology.authorizationservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
    public List<Authorities> getAuthorities(@RequestParam("user") String user,
                                            @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }
}