package com.restaurant.model;

import com.restaurant.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class User {
    private long id;
    private String name;
    private String phone;
    private String login;
    private String password;
    private Role role;

    public User(String name, String phone, String login, String password, Role role) {
    }

    public User(String name, String login, String password, Role role) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
