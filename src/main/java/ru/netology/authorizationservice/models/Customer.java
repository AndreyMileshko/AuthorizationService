package ru.netology.authorizationservice.models;

import java.util.Objects;

public class Customer {
    private final String user;
    private final String password;

    public Customer(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(user, customer.user) && Objects.equals(password, customer.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, password);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
