package com.restaurant.model;

import com.restaurant.model.enums.Role;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class User {
    private long id;
    private String name;
    private String phone;
    private String login;
    private String password;
    private Role role;

}
