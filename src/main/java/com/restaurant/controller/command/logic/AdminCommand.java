package com.restaurant.controller.command.logic;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.data.Page;
import com.restaurant.model.enums.Status;
import com.restaurant.service.OrderService;
import com.restaurant.service.ServiceFactory;
import com.restaurant.service.UserService;
import com.restaurant.controller.command.Command;
import com.restaurant.controller.data.Page;
import com.restaurant.service.ServiceFactory;
import com.restaurant.service.UserService;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.ADMIN_PAGE;

public class AdminCommand implements Command {

    private UserService userService;


    public AdminCommand() {
        this.userService = ServiceFactory.getUserService();

    }

    @Override
    public Page perform(HttpServletRequest request) {
//        request.setAttribute("ordersNew", orderService.getAllByStatus(Status.NEW));
//        request.setAttribute("ordersOffer", orderService.getAllByStatus(Status.OFFER));
//        request.setAttribute("ordersInProgress", orderService.getAllByStatus(Status.IN_PROGRESS));
//        request.setAttribute("ordersCompleted", orderService.getAllByStatus(Status.COMPLETED));
//        request.setAttribute("ordersCanceled", orderService.getAllByStatus(Status.CANCELED));
//        request.setAttribute("ordersCl", orderService.getAllByStatus(Status.CLOSED));

        return new Page(ADMIN_PAGE);
    }
}
