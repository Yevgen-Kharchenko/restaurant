package com.restaurant.controller.command.logic;

import com.restaurant.controller.command.UniCommand;
import com.restaurant.controller.data.PageResponse;
import com.restaurant.model.Dish;
import com.restaurant.model.enums.DishType;
import com.restaurant.service.DishService;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.google.common.primitives.Ints.tryParse;
import static com.restaurant.controller.PageUrlConstants.DISH_PAGE;
import static com.restaurant.controller.PageUrlConstants.EDIT_MENU_PAGE;

@AllArgsConstructor
public class DishCommand extends UniCommand {

    private static final Logger LOG = Logger.getLogger(DishCommand.class);
    private DishService dishService;

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
        String nameUK = request.getParameter("nameUK");
        String nameEN = request.getParameter("nameEN");
        String ingredientsUK = request.getParameter("ingredientsUK");
        String ingredientsEN = request.getParameter("ingredientsEN");
        double price = Double.parseDouble(request.getParameter("price"));
        String dishId = request.getParameter("dishId");
        DishType dishType = DishType.valueOf(request.getParameter("dishType"));
        long id = tryParse(dishId);
        String fileName = request.getParameter("images");

        if (id == 0) {
            LOG.info("id=0 create dish");
            dishService.createDish(dishType, nameUK, nameEN, ingredientsUK, ingredientsEN, price, fileName);
        } else {
            LOG.info("id!=0 update dish");
            dishService.updateDish(id, dishType, nameUK, nameEN, ingredientsUK, ingredientsEN, price, fileName);
        }


        return new PageResponse(EDIT_MENU_PAGE, true);
    }
}
