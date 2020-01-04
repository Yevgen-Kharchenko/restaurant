package com.restaurant.controller.command.info;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.data.Page;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.BLOG_PAGE;

public class BlogCommand implements Command {
    @Override
    public Page perform(HttpServletRequest request) {
        return new Page(BLOG_PAGE);
    }
}
