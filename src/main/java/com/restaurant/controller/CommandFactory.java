package com.restaurant.controller;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.command.admin.HomeCommand;
import com.restaurant.controller.command.error.NotFoundCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static Map<String, Command> getCommandMap = new HashMap<>();
    private static Map<String, Command> postCommandMap = new HashMap<>();
    private static Command defaultCommand = new NotFoundCommand();

    static {
        getCommandMap.put("/", new HomeCommand());


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
