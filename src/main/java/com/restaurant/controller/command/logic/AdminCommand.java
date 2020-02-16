package com.restaurant.controller.command.logic;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.data.PageResponse;
import lombok.AllArgsConstructor;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.ADMIN_PAGE;

@AllArgsConstructor
public class AdminCommand implements Command {

    @Override
    public PageResponse execute(HttpServletRequest request) {
        return new PageResponse(ADMIN_PAGE);
    }
}
