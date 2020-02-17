package com.restaurant.controller.command.logic;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.data.PageResponse;
import com.restaurant.service.OrderService;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.ORDER_PAGE;

@AllArgsConstructor
public class DishOrderDeleteCommand implements Command {
    private static final Logger LOG = Logger.getLogger(DishOrderDeleteCommand.class);

    private OrderService orderService;

    public static final String ORDER_ID = "orderId";
    public static final String DISH_ID = "orderDishId";

    @Override
    public PageResponse execute(HttpServletRequest request) {
        long orderId = Long.parseLong(request.getParameter(ORDER_ID));
        long dishId = Long.parseLong(request.getParameter(DISH_ID));
        orderService.deleteOrderDish(dishId, orderId);
        LOG.info("delete orderDisd " + dishId);

        return new PageResponse(ORDER_PAGE + "?orderId=" + orderId, true);
    }
}
