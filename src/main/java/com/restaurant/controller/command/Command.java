package com.restaurant.controller.command;

import com.restaurant.controller.data.CommandResponse;

import javax.servlet.http.HttpServletRequest;

public interface Command {

    CommandResponse execute(HttpServletRequest request);
}
