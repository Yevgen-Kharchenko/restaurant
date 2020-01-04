package com.restaurant.controller.command.admin;

import com.restaurant.controller.command.UniCommand;
import com.restaurant.controller.data.Page;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.LOGIN_PAGE;
import static com.restaurant.controller.PageUrlConstants.REGISTER_PAGE;

public class RegisterCommand extends UniCommand {

    private static final Logger LOG = Logger.getLogger(RegisterCommand.class);

    @Override
    protected Page performGet(HttpServletRequest request) {
        return new Page(REGISTER_PAGE);
    }

    @Override
    protected Page performPost(HttpServletRequest request) {


        return new Page("/", true);
    }
}
