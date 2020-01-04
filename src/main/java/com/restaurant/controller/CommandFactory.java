package com.restaurant.controller;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.command.admin.*;
import com.restaurant.controller.command.error.ErrorCommand;
import com.restaurant.controller.command.error.NotFoundCommand;
import com.restaurant.controller.command.info.*;
import com.restaurant.controller.command.logic.MenuCommand;
import com.restaurant.controller.command.logic.ReservationCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static Map<String, Command> getCommandMap = new HashMap<>();
    private static Map<String, Command> postCommandMap = new HashMap<>();
    private static Command defaultCommand = new NotFoundCommand();

    static {
        getCommandMap.put("/", new HomeCommand());
        getCommandMap.put("/about", new AboutUsCommand());
        getCommandMap.put("/blog", new BlogCommand());
        getCommandMap.put("/contact", new ContactCommand());
        getCommandMap.put("/blog-single", new BlogSingleCommand());
        getCommandMap.put("/menu", new MenuCommand());
        getCommandMap.put("/reservation", new ReservationCommand());
        getCommandMap.put("/specialties", new SpecialtiesCommand());
        getCommandMap.put("/error", new ErrorCommand());
        getCommandMap.put("/language", new LanguageCommand());
        getCommandMap.put("/login", new LoginCommand());
        getCommandMap.put("/register", new RegisterCommand());
        getCommandMap.put("/logout", new LogoutCommand());


        postCommandMap.put("/", new HomeCommand());

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
