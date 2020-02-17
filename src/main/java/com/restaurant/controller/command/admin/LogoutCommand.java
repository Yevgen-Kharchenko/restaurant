package com.restaurant.controller.command.admin;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.data.PageResponse;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.HOME_PAGE;

public class LogoutCommand implements Command {
    private static final Logger LOG = Logger.getLogger(LogoutCommand.class);

    @Override
    public PageResponse execute(HttpServletRequest request) {
        request.getSession().invalidate();
        LOG.info("Logout session");

        return new PageResponse(HOME_PAGE, true);
    }
}
