package com.restaurant.repository;

import com.restaurant.model.User;

public interface UserDao{


    boolean isUserExists(String login);

    User getByLogin(String login);


}
