package com.restaurant.controller.command.info;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.data.PageResponse;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.ABOUT_US_PAGE;

public class AboutUsCommand implements Command {
    @Override
    public PageResponse execute(HttpServletRequest request) {
        return new PageResponse(ABOUT_US_PAGE);
    }
}
