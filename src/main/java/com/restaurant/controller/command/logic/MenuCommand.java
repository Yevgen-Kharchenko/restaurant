package com.restaurant.controller.command.logic;

import com.restaurant.controller.command.UniCommand;
import com.restaurant.controller.data.Page;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.MENU_PAGE;

public class MenuCommand extends UniCommand {
    private static final Logger LOG = Logger.getLogger(MenuCommand.class);

    @Override
    protected Page performGet(HttpServletRequest request) {
        return new Page(MENU_PAGE);
    }

    @Override
    protected Page performPost(HttpServletRequest request) {


        return new Page("/", true);
    }
}
