package com.restaurant.controller.command.logic;

import com.restaurant.controller.command.UniCommand;
import com.restaurant.controller.data.Page;
import com.restaurant.model.enums.DishType;
import com.restaurant.service.DishService;
import com.restaurant.service.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.MENU_PAGE;

public class MenuCommand extends UniCommand {
    private static final Logger LOG = Logger.getLogger(MenuCommand.class);
    private DishService dishService;

    public static final String LOCALE = "locale";

    public MenuCommand() {
        this.dishService = ServiceFactory.getDishService();}


    @Override
    protected Page performGet(HttpServletRequest request) {
        String local = (String) request.getSession().getAttribute(LOCALE);
        LOG.info("LOCAL= "+local);
//        request.setAttribute("dishMainList", dishService.getAllByField(local, DishType.MAIN));
        request.setAttribute("dishMainList", dishService.getAllByField(local, DishType.MAIN));
        LOG.info("setAttribute  dishMainList"+(dishService.getAllByField(local, DishType.MAIN)).isEmpty());
        request.setAttribute("dishDessertList", dishService.getAllByField(local, DishType.DESSERT));
        LOG.info("setAttribute  dishDessertList"+(dishService.getAllByField(local, DishType.DESSERT)).toString());
        request.setAttribute("dishDrinksList", dishService.getAllByField(local, DishType.DRINKS));
        LOG.info("setAttribute  dishDrinksList"+(dishService.getAllByField(local, DishType.DRINKS)).size());
        return new Page(MENU_PAGE);
    }

    @Override
    protected Page performPost(HttpServletRequest request) {


        return new Page("/", true);
    }
}
