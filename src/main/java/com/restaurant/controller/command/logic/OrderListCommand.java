package com.restaurant.controller.command.logic;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.data.PageResponse;
import com.restaurant.model.enums.Status;
import com.restaurant.service.OrderService;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.ORDER_LIST_PAGE;

@AllArgsConstructor
public class OrderListCommand implements Command {
    private static final Logger LOG = Logger.getLogger(OrderListCommand.class);

    private OrderService orderService;

    @Override
    public PageResponse execute(HttpServletRequest request) {
        request.setAttribute("ordersNew", orderService.getAllByStatus(Status.NEW));
        request.setAttribute("ordersInProgress", orderService.getAllByStatus(Status.IN_PROGRESS));
        request.setAttribute("ordersCompleted", orderService.getAllByStatus(Status.COMPLETED));
        request.setAttribute("ordersPayment", orderService.getAllByStatus(Status.PAYMENT));
        request.setAttribute("ordersCanceled", orderService.getAllByStatus(Status.CANCELED));
        request.setAttribute("ordersClosed", orderService.getAllByStatus(Status.CLOSED));
        LOG.info("OrderListCommand GET");
        return new PageResponse(ORDER_LIST_PAGE);
    }
}
