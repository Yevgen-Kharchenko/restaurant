package com.restaurant.controller.command.logic;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.data.Page;
import com.restaurant.service.ServiceFactory;
import com.restaurant.service.UserService;
import com.restaurant.service.DishService;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.EDIT_MENU_PAGE;

public class DishDeleteCommand implements Command {

    private DishService dishService;

    public DishDeleteCommand() {
        this.dishService = ServiceFactory.getDishService();
    }

    public static final String ID = "id";

    @Override
    public Page perform(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter(ID));
        dishService.deleteDish(id);
        return new Page("/"+EDIT_MENU_PAGE, true);
    }
}
