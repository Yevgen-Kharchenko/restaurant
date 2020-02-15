package com.restaurant.controller.command.logic;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.data.PageResponse;
import com.restaurant.service.ServiceFactory;
import com.restaurant.service.DishService;
import lombok.AllArgsConstructor;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.EDIT_MENU_PAGE;

@AllArgsConstructor
public class DishDeleteCommand implements Command {

    private DishService dishService;

    public static final String ID = "id";

    @Override
    public PageResponse execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter(ID));
        dishService.deleteDish(id);
        return new PageResponse(EDIT_MENU_PAGE, true);
    }
}
