package com.restaurant.controller.command.logic;

import com.restaurant.controller.command.UniCommand;
import com.restaurant.controller.data.PageResponse;
import com.restaurant.model.User;
import com.restaurant.model.enums.DishType;
import com.restaurant.service.DishService;
import com.restaurant.service.OrderService;
import com.restaurant.service.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

import static com.restaurant.controller.PageUrlConstants.MENU_PAGE;

public class MenuCommand extends UniCommand {
    private static final Logger LOG = Logger.getLogger(MenuCommand.class);
    private DishService dishService;
    private OrderService orderService;

    public static final String LOCALE = "locale";

    public MenuCommand() {
        this.dishService = ServiceFactory.getDishService();
        this.orderService = ServiceFactory.getOrderService();
    }


    @Override
    protected PageResponse performGet(HttpServletRequest request) {
        String local = (String) request.getSession().getAttribute(LOCALE);
        LOG.info("LOCAL= " + local);
        request.setAttribute("dishMainList", dishService.getAllByField(DishType.MAIN, local));
        LOG.info("setAttribute  dishMainList" + (dishService.getAllByField(DishType.MAIN, local)).isEmpty());
        request.setAttribute("dishDessertList", dishService.getAllByField(DishType.DESSERT, local));
        LOG.info("setAttribute  dishDessertList" + (dishService.getAllByField(DishType.DESSERT, local)).toString());
        request.setAttribute("dishDrinksList", dishService.getAllByField(DishType.DRINKS, local));
        LOG.info("setAttribute  dishDrinksList" + (dishService.getAllByField(DishType.DRINKS, local)).size());
        return new PageResponse(MENU_PAGE);
    }

    @Override
    protected PageResponse performPost(HttpServletRequest request) {
        HttpSession session = request.getSession();


        User user = (User) session.getAttribute("user");

        long orderId = orderService.createOrder(user.getId());
        long dishId;
        int quantity;

        Map<String, String[]> params = request.getParameterMap();

        for (Map.Entry<String, String[]> entry : params.entrySet()) {

            dishId = Long.parseLong(entry.getKey());
            quantity = Integer.parseInt(entry.getValue()[0]);
            orderService.addOrderDish(dishId, orderId, quantity);
        }

        double amount = orderService.getTotalAmount(orderId);
        orderService.updateAmountInOrderRepository(amount, orderId);

        return new PageResponse("/" + MENU_PAGE, true);
    }
}
