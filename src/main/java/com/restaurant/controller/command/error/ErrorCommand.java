package com.restaurant.controller.command.error;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.data.Page;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.ERROR_PAGE;

public class ErrorCommand implements Command {

    @Override
    public Page perform(HttpServletRequest request) {
        return new Page(ERROR_PAGE);
    }
}
