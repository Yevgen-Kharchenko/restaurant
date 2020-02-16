package com.restaurant.controller.command.logic;

import com.restaurant.controller.command.UniCommand;
import com.restaurant.controller.data.PageResponse;
import com.restaurant.model.enums.DishType;
import com.restaurant.service.DishService;
import com.restaurant.service.OrderService;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.ORDER_PAGE;

@AllArgsConstructor
public class OrderCommand extends UniCommand {
    private static final Logger LOG = Logger.getLogger(OrderCommand.class);
    private OrderService orderService;
    private DishService dishService;
    public static final String ID = "orderId";
    public static final String LOCALE = "locale";

    @Override
    protected PageResponse performGet(HttpServletRequest request) {
        long orderId = Long.parseLong(request.getParameter(ID));
        String local = (String) request.getSession().getAttribute(LOCALE);
        request.setAttribute("order", orderService.getById(orderId, local));
        request.setAttribute("main", dishService.getAllByField(DishType.MAIN, local));
        request.setAttribute("dessert", dishService.getAllByField(DishType.DESSERT, local));
        request.setAttribute("drinks", dishService.getAllByField(DishType.DRINKS, local));
        LOG.info("OrderCommand GET");
        return new PageResponse(ORDER_PAGE);
    }

    @Override
    protected PageResponse performPost(HttpServletRequest request) {
        return new PageResponse(ORDER_PAGE, false);
    }
}
