package com.restaurant.controller.command;

import com.restaurant.controller.data.Page;

import javax.servlet.http.HttpServletRequest;

public interface Command {

    Page perform(HttpServletRequest request);
}
