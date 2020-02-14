package com.restaurant.controller.command.error;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.data.PageResponse;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.NOT_FOUND_PAGE;

public class NotFoundCommand implements Command {

    @Override
    public PageResponse execute(HttpServletRequest request) {
        return new PageResponse(NOT_FOUND_PAGE);
    }
}
