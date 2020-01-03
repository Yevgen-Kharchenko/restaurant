package com.restaurant.controller.command.error;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.data.Page;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.UNDER_CONSTRUCTION_PAGE;

public class UnderConstructionCommand implements Command {
    @Override
    public Page perform(HttpServletRequest request) {
        return new Page(UNDER_CONSTRUCTION_PAGE);
    }
}
