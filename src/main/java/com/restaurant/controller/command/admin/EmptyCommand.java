package com.restaurant.controller.command.admin;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.data.Page;
import com.restaurant.service.ServiceFactory;
import com.restaurant.service.UserService;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.EMPTY_PAGE;

public class EmptyCommand implements Command {

    private UserService userService;


    public EmptyCommand() {
        this.userService = ServiceFactory.getUserService();

    }

    @Override
    public Page perform(HttpServletRequest request) {

        return new Page(EMPTY_PAGE);
    }
}
