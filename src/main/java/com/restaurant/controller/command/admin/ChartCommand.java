package com.restaurant.controller.command.admin;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.data.PageResponse;
import com.restaurant.service.ServiceFactory;
import com.restaurant.service.UserService;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.CHART_PAGE;

public class ChartCommand implements Command {

    @Override
    public PageResponse execute(HttpServletRequest request) {

        return new PageResponse(CHART_PAGE);
    }
}
