package com.restaurant.controller.command.logic;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.data.PageResponse;
import com.restaurant.service.OrderService;
import com.restaurant.service.ServiceFactory;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.ORDER_PAGE;

@AllArgsConstructor
public class AddOrderDishCommand implements Command {
    private static final Logger LOG = Logger.getLogger(AddOrderDishCommand.class);
    private OrderService orderService;

    public static final String ORDER_ID = "orderId";
    public static final String DISH_ID = "dishId";

    @Override
    public PageResponse execute(HttpServletRequest request) {
        long orderId = Long.parseLong(request.getParameter(ORDER_ID));
        long dishId = Long.parseLong(request.getParameter(DISH_ID));
        LOG.info("Create new orderDish");
        orderService.addOrderDish(dishId, orderId,1);

        return new PageResponse( ORDER_PAGE + "?orderId=" + orderId, true);
    }
}
