package com.restaurant.controller.command.logic;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.data.PageResponse;
import com.restaurant.model.enums.Status;
import com.restaurant.service.OrderService;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.CHEF_PAGE;

@AllArgsConstructor
public class ChefCommand implements Command {

    private static final Logger LOG = Logger.getLogger(ChefCommand.class);
    private OrderService orderService;
    public static final String LOCALE = "locale";

    @Override
    public PageResponse execute(HttpServletRequest request) {
        LOG.info("CHEF command get");
        String local = (String) request.getSession().getAttribute(LOCALE);
        request.setAttribute("ordersInProgress", orderService.getAllByStatus(Status.IN_PROGRESS));
        request.setAttribute("orderDish", orderService.getAllForChef(local));

        return new PageResponse(CHEF_PAGE);
    }
}
