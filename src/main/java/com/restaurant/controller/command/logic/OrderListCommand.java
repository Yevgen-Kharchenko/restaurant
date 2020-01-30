package com.restaurant.controller.command.logic;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.data.Page;
import com.restaurant.model.enums.Status;
import com.restaurant.service.OrderService;
import com.restaurant.service.ServiceFactory;
import com.restaurant.service.UserService;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.ORDER_LIST_PAGE;

public class OrderListCommand implements Command {


    private OrderService orderService;

    public OrderListCommand() {

        this.orderService = ServiceFactory.getOrderService();

    }

    @Override
    public Page perform(HttpServletRequest request) {
        request.setAttribute("ordersNew", orderService.getAllByStatus(Status.NEW));
        request.setAttribute("ordersInProgress", orderService.getAllByStatus(Status.IN_PROGRESS));
        request.setAttribute("ordersCompleted", orderService.getAllByStatus(Status.COMPLETED));
        request.setAttribute("ordersCanceled", orderService.getAllByStatus(Status.CANCELED));
        request.setAttribute("ordersClosed", orderService.getAllByStatus(Status.CLOSED));

        return new Page(ORDER_LIST_PAGE);
    }
}
