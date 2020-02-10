package com.restaurant.controller.command.admin;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.data.Page;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.REDIRECT_HOME_PAGE;

public class LogoutCommand implements Command {
    @Override
    public Page perform(HttpServletRequest request) {
        String originUrl = request.getHeader("referer");
        request.getSession().invalidate();

        return new Page(originUrl, true);
    }
}
