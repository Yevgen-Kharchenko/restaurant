package com.restaurant.controller.command;

import com.restaurant.controller.data.PageResponse;

import javax.servlet.http.HttpServletRequest;

public interface Command {

    PageResponse execute(HttpServletRequest request);
}
