package com.restaurant.controller.command.admin;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.data.Page;
import com.restaurant.service.ServiceFactory;
import com.restaurant.service.UserService;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.ELEMENT_PAGE;

public class ElementCommand implements Command {

    private UserService userService;


    public ElementCommand() {
        this.userService = ServiceFactory.getUserService();

    }

    @Override
    public Page perform(HttpServletRequest request) {

        return new Page(ELEMENT_PAGE);
    }
}
