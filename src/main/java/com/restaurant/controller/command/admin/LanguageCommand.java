package com.restaurant.controller.command.admin;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.data.Page;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.REDIRECT_HOME_PAGE;

public class LanguageCommand implements Command {

    public static final String LOCALE = "locale";

    @Override
    public Page perform(HttpServletRequest request) {
        String locale = request.getParameter(LOCALE);

        request.getSession().setAttribute(LOCALE, locale);

        return new Page(REDIRECT_HOME_PAGE, true);
    }
}
