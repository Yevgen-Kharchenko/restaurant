package com.restaurant.controller.command.admin;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.data.Page;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.HOME_PAGE;

public class HomeCommand implements Command {
    private static final Logger LOG = Logger.getLogger(HomeCommand.class);

    @Override
    public Page perform(HttpServletRequest request) {
        return new Page(HOME_PAGE);
    }
}
