package ru.netology.authorizationservice.exceptionHandlers.userException;

public class InvalidCredentials extends RuntimeException {
    public InvalidCredentials(String msg) {
        super(msg);
    }
}