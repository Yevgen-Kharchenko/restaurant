package com.restaurant.controller.command.logic;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.data.PageResponse;
import com.restaurant.service.OrderService;
import com.restaurant.service.ServiceFactory;
import lombok.AllArgsConstructor;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.ORDER_PAGE;

@AllArgsConstructor
public class DishOrderDeleteCommand implements Command {

    private OrderService orderService;

    public static final String ORDER_ID = "orderId";
    public static final String DISH_ID = "orderDishId";

    @Override
    public PageResponse execute(HttpServletRequest request) {
        long orderId = Long.parseLong(request.getParameter(ORDER_ID));
        long dishId = Long.parseLong(request.getParameter(DISH_ID));
        orderService.deleteOrderDish(dishId,orderId);

        return new PageResponse(ORDER_PAGE+"?orderId="+orderId,true);
    }
}
