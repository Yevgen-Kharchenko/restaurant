package com.restaurant.controller.command.admin;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.data.PageResponse;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.*;
public class LogoutCommand implements Command {

    @Override
    public PageResponse execute(HttpServletRequest request) {
        request.getSession().invalidate();

        return new PageResponse(HOME_PAGE, true);
    }
}
