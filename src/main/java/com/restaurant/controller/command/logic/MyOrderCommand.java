package com.restaurant.controller.command.logic;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.data.PageResponse;
import com.restaurant.model.User;
import com.restaurant.service.OrderService;
import lombok.AllArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.restaurant.controller.PageUrlConstants.MY_ORDER_PAGE;

@AllArgsConstructor
public class MyOrderCommand implements Command {

    private OrderService orderService;
    public static final String ID = "orderId";
    public static final String LOCALE = "locale";

    @Override
    public PageResponse execute(HttpServletRequest request) {
        String local = (String) request.getSession().getAttribute(LOCALE);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        request.setAttribute("myOrders", orderService.getAllForUser(local, user.getId()));

        return new PageResponse(MY_ORDER_PAGE);
    }
}
