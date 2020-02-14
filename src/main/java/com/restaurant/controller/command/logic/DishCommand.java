package com.restaurant.controller.command.logic;

import com.restaurant.controller.command.UniCommand;
import com.restaurant.controller.data.PageResponse;
import com.restaurant.model.Dish;
import com.restaurant.model.enums.DishType;
import com.restaurant.service.DishService;
import com.restaurant.service.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static com.google.common.primitives.Ints.tryParse;
import static com.restaurant.controller.PageUrlConstants.DISH_PAGE;
import static com.restaurant.controller.PageUrlConstants.EDIT_MENU_PAGE;

public class DishCommand extends UniCommand {

    private static final Logger LOG = Logger.getLogger(DishCommand.class);
    private DishService dishService;

    public DishCommand() {
        this.dishService = ServiceFactory.getDishService();
    }

    public static final String ID = "id";

    @Override
    protected PageResponse performGet(HttpServletRequest request) {
        long id = tryParse(request.getParameter(ID));
        if (id != 0) {
            Dish dish = dishService.getDish(id);
            request.setAttribute("dish", dish);
            LOG.info("set dish: " + dish);
        }
        return new PageResponse(DISH_PAGE);
    }

    @Override
    protected PageResponse performPost(HttpServletRequest request) {
        LOG.info("dish post command");
        DishType dishType = DishType.valueOf(request.getParameter("dishType"));
        String nameUK = request.getParameter("nameUK");
        String nameEN = request.getParameter("nameEN");
        String ingredientsUK = request.getParameter("ingredientsUK");
        String ingredientsEN = request.getParameter("ingredientsEN");
        double price = Double.parseDouble(request.getParameter("price"));
        String dishId = request.getParameter("dishId");
        long id = tryParse(dishId);
        if (id == 0) {
            LOG.info("id=0 create dish");
            dishService.createDish(dishType, nameUK, nameEN, ingredientsUK, ingredientsEN, price);
        } else {
            LOG.info("id!=0 update dish");
            dishService.updateDish(id, dishType, nameUK, nameEN, ingredientsUK, ingredientsEN, price);
        }

        return new PageResponse(EDIT_MENU_PAGE, true);
    }
}
