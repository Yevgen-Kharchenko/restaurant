package com.restaurant.controller.command.info;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.data.Page;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.BLOG_SINGLE_PAGE;

public class BlogSingleCommand implements Command {
    @Override
    public Page perform(HttpServletRequest request) {
        return new Page(BLOG_SINGLE_PAGE);
    }
}
