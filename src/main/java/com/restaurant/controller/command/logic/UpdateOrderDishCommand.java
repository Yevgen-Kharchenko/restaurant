package com.restaurant.controller.command.logic;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.data.PageResponse;
import com.restaurant.service.OrderService;
import com.restaurant.service.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.ORDER_PAGE;

public class UpdateOrderDishCommand implements Command {
    private static final Logger LOG = Logger.getLogger(UpdateOrderDishCommand.class);
    private OrderService orderService;


    public UpdateOrderDishCommand() {
        this.orderService = ServiceFactory.getOrderService();
    }

    public static final String QTY = "qty";
    public static final String DISH_ID = "orderDishId";
    public static final String ORDER_ID = "orderId";

    @Override
    public PageResponse execute(HttpServletRequest request) {
        int quantity = Integer.parseInt(request.getParameter(QTY));
        long dishId = Long.parseLong(request.getParameter(DISH_ID));
        long orderId = Long.parseLong(request.getParameter(ORDER_ID));
        LOG.info("update orderDish qty");
        orderService.UpdateOrderDish(dishId, quantity, orderId);
        return new PageResponse("/" + ORDER_PAGE + "?orderId=" + orderId, true);
    }
}
