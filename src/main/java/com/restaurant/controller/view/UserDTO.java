package com.restaurant.controller.view;

import com.restaurant.model.enums.Role;
import lombok.*;


@Getter
@Setter
@ToString
@Builder
public class UserDTO {
    private long id;
    private String name;
    private String phone;
    private String login;
    private String password;
    private Role role;

}
