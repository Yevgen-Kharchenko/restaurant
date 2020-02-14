package com.restaurant.controller.command.error;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.data.PageResponse;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.UNDER_CONSTRUCTION_PAGE;

public class UnderConstructionCommand implements Command {
    @Override
    public PageResponse execute(HttpServletRequest request) {
        return new PageResponse(UNDER_CONSTRUCTION_PAGE);
    }
}
