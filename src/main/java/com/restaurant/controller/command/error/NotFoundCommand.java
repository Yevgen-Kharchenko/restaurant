package com.restaurant.controller.command.error;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.data.Page;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.NOT_FOUND_PAGE;

public class NotFoundCommand implements Command {

    @Override
    public Page perform(HttpServletRequest request) {
        return new Page(NOT_FOUND_PAGE);
    }
}
