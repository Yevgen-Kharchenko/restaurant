package com.restaurant.controller.command;

import com.restaurant.controller.data.Page;

import javax.servlet.http.HttpServletRequest;

public abstract class UniCommand implements Command {

    @Override
    public Page perform(HttpServletRequest request) {

        String type = request.getMethod();

        return "GET".equals(type)
                ? performGet(request)
                : performPost(request);
    }

    protected abstract Page performGet(HttpServletRequest request);

    protected abstract Page performPost(HttpServletRequest request);
}
