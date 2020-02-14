package com.restaurant.controller.command.logic;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.data.PageResponse;
import com.restaurant.service.OrderService;
import com.restaurant.service.ServiceFactory;
import com.restaurant.service.UserService;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.ADMIN_PAGE;

public class AdminCommand implements Command {

    private UserService userService;
    private OrderService orderService;


    public AdminCommand() {
        this.userService = ServiceFactory.getUserService();
        this.orderService = ServiceFactory.getOrderService();

    }

    @Override
    public PageResponse execute(HttpServletRequest request) {
//        request.setAttribute("ordersNew", orderService.getAllByStatus(Status.NEW));
//        request.setAttribute("ordersOffer", orderService.getAllByStatus(Status.OFFER));
//        request.setAttribute("ordersInProgress", orderService.getAllByStatus(Status.IN_PROGRESS));
//        request.setAttribute("ordersCompleted", orderService.getAllByStatus(Status.COMPLETED));
//        request.setAttribute("ordersCanceled", orderService.getAllByStatus(Status.CANCELED));
//        request.setAttribute("ordersCl", orderService.getAllByStatus(Status.CLOSED));

        return new PageResponse(ADMIN_PAGE);
    }
}
