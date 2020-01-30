package com.restaurant.repository;

import com.restaurant.model.User;

public interface UserDao{


    boolean isUserExists(String login);

    boolean isEmailExist(String email);

    User getByLogin(String login);


}
