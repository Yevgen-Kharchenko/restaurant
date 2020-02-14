package com.restaurant.controller.command;

import com.restaurant.controller.data.PageResponse;

import javax.servlet.http.HttpServletRequest;

public abstract class UniCommand implements Command {

    @Override
    public PageResponse execute(HttpServletRequest request) {

        String type = request.getMethod();

        return "GET".equals(type)
                ? performGet(request)
                : performPost(request);
    }

    protected abstract PageResponse performGet(HttpServletRequest request);

    protected abstract PageResponse performPost(HttpServletRequest request);
}
