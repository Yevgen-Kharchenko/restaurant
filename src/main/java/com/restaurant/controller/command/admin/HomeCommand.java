package com.restaurant.controller.command.admin;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.data.PageResponse;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.HOME_PAGE;

public class HomeCommand implements Command {
    private static final Logger LOG = Logger.getLogger(HomeCommand.class);

    @Override
    public PageResponse execute(HttpServletRequest request) {
        return new PageResponse(HOME_PAGE);
    }
}
