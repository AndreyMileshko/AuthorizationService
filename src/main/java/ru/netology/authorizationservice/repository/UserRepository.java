package ru.netology.authorizationservice.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private final Map<String, HashMap<String, List<Authorities>>> userLibrary = new HashMap<>();

    public List<Authorities> getUserAuthorities(String user, String password) {
        addedUserTest();    //метод для тестирования

        if (!userLibrary.containsKey(user)) {
            return new ArrayList<>();
        }
        HashMap<String, List<Authorities>> correctUsernameMap = userLibrary.get(user);
        if (!correctUsernameMap.containsKey(password)) {
            return new ArrayList<>();
        }
        return correctUsernameMap.get(password);
    }

    private void addedUserTest() {
        userLibrary.put("Andrey", new HashMap<>());
        List<Authorities> authoritiesList = new ArrayList<>();
        authoritiesList.add(Authorities.READ);
        authoritiesList.add(Authorities.WRITE);
        authoritiesList.add(Authorities.DELETE);
        userLibrary.get("Andrey").put("hello", authoritiesList);
    }
}
