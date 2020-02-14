package com.restaurant.controller.command.admin;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.data.PageResponse;

import javax.servlet.http.HttpServletRequest;

public class LanguageCommand implements Command {

    public static final String LOCALE = "locale";

    @Override
    public PageResponse execute(HttpServletRequest request) {
        String locale = request.getParameter(LOCALE);
        String originUrl = request.getHeader("referer");
        request.getSession().setAttribute(LOCALE, locale);

        return new PageResponse(originUrl, true);
    }
}
