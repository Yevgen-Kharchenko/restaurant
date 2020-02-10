package com.restaurant.controller;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.command.admin.*;
import com.restaurant.controller.command.error.ErrorCommand;
import com.restaurant.controller.command.error.NotFoundCommand;
import com.restaurant.controller.command.error.UnderConstructionCommand;
import com.restaurant.controller.command.info.*;
import com.restaurant.controller.command.logic.*;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static Map<String, Command> getCommandMap = new HashMap<>();
    private static Map<String, Command> postCommandMap = new HashMap<>();
    private static Command defaultCommand = new NotFoundCommand();

    static {
        getCommandMap.put("/", new HomeCommand());
        getCommandMap.put("/under-construction", new UnderConstructionCommand());
        getCommandMap.put("/index", new AdminCommand());
        getCommandMap.put("/order-list", new OrderListCommand());
        getCommandMap.put("/ui-elements", new ElementCommand());
        getCommandMap.put("/chart", new ChartCommand());
        getCommandMap.put("/chef", new ChefCommand());
        getCommandMap.put("/tab-panel", new TabPanelCommand());
        getCommandMap.put("/table", new TableCommand());
        getCommandMap.put("/form", new FormCommand());
        getCommandMap.put("/empty", new EmptyCommand());
        getCommandMap.put("/about", new AboutUsCommand());
        getCommandMap.put("/blog", new BlogCommand());
        getCommandMap.put("/contact", new ContactCommand());
        getCommandMap.put("/blog-single", new BlogSingleCommand());
        getCommandMap.put("/menu", new MenuCommand());
        getCommandMap.put("/edit-menu", new EditMenuCommand());
        getCommandMap.put("/reservation", new ReservationCommand());
        getCommandMap.put("/specialties", new SpecialtiesCommand());
        getCommandMap.put("/error", new ErrorCommand());
        getCommandMap.put("/language", new LanguageCommand());
        getCommandMap.put("/login", new LoginCommand());
        getCommandMap.put("/register", new RegisterCommand());
        getCommandMap.put("/logout", new LogoutCommand());
        getCommandMap.put("/dish", new DishCommand());
        getCommandMap.put("/dish-delete", new DishDeleteCommand());
        getCommandMap.put("/order", new OrderCommand());
        getCommandMap.put("/order-dish-delete", new DishOrderDeleteCommand());
        getCommandMap.put("/add-order-dish", new AddOrderDishCommand());
        getCommandMap.put("/update-order-dish-quantity", new UpdateOrderDishCommand());
        getCommandMap.put("/my-orders", new MyOrderCommand());
        getCommandMap.put("/invoice", new InvoiceCommand());



        postCommandMap.put("/", new HomeCommand());
        postCommandMap.put("/invoice", new InvoiceCommand());
        postCommandMap.put("/login", new LoginCommand());
        postCommandMap.put("/register", new RegisterCommand());
        postCommandMap.put("/menu", new MenuCommand());
        postCommandMap.put("/edit-menu", new EditMenuCommand());
        postCommandMap.put("/dish", new DishCommand());
        postCommandMap.put("/status", new StatusCommand());
        postCommandMap.put("/order", new OrderCommand());

    }

    private CommandFactory() {
    }

    public static Command getCommand(String path, String type) {

        return "GET".equals(type)
                ? getCommand(path)
                : postCommand(path);
    }

    private static Command getCommand(String path) {
        return getCommandMap.getOrDefault(path, defaultCommand);
    }

    private static Command postCommand(String path) {
        return postCommandMap.getOrDefault(path, defaultCommand);
    }
}
