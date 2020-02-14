package com.restaurant.controller.command.info;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.data.PageResponse;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.CONTACT_PAGE;

public class ContactCommand implements Command {
    @Override
    public PageResponse execute(HttpServletRequest request) {
        return new PageResponse(CONTACT_PAGE);
    }
}
