package com.restaurant.controller.command.logic;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.data.Page;
import com.restaurant.model.enums.Status;
import com.restaurant.service.DishService;
import com.restaurant.service.OrderService;
import com.restaurant.service.ServiceFactory;
import com.restaurant.service.UserService;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.CHEF_PAGE;
import static com.restaurant.controller.PageUrlConstants.ORDER_LIST_PAGE;

public class ChefCommand implements Command {


    private OrderService orderService;


    public ChefCommand() {

        this.orderService = ServiceFactory.getOrderService();

    }

    @Override
    public Page perform(HttpServletRequest request) {
        request.setAttribute("ordersInProgress", orderService.getAllByStatus(Status.IN_PROGRESS));
        request.setAttribute("orderDish", orderService.getAllByStatus(Status.IN_PROGRESS));

        return new Page(CHEF_PAGE);
    }
}
