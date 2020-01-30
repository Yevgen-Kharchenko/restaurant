package com.restaurant.controller.command.admin;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.data.Page;
import com.restaurant.service.ServiceFactory;
import com.restaurant.service.UserService;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.FORM_PAGE;

public class FormCommand implements Command {

    private UserService userService;


    public FormCommand() {
        this.userService = ServiceFactory.getUserService();

    }

    @Override
    public Page perform(HttpServletRequest request) {

        return new Page(FORM_PAGE);
    }
}
