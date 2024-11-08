package ru.netology.authorizationservice.exceptionHandlers.userException;

public class UnauthorizedUser extends RuntimeException {
    public UnauthorizedUser(String msg) {
        super(msg);
    }
}