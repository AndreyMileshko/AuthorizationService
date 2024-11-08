package ru.netology.authorizationservice.service;

import org.springframework.stereotype.Service;
import ru.netology.authorizationservice.exceptionHandlers.userException.InvalidCredentials;
import ru.netology.authorizationservice.exceptionHandlers.userException.UnauthorizedUser;
import ru.netology.authorizationservice.repository.Authorities;
import ru.netology.authorizationservice.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
    final UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("Username or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}