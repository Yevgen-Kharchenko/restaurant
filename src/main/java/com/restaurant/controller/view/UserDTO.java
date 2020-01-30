package com.restaurant.controller.view;

import com.restaurant.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserDTO {
    private long id;
    private String name;
    private String phone;
    private String login;
    private String password;
    private Role role;

    public UserDTO() {

    }
}
