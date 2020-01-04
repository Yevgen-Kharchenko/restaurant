package com.restaurant.controller.command.logic;

import com.restaurant.controller.command.UniCommand;
import com.restaurant.controller.data.Page;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.RESERVATION_PAGE;

public class ReservationCommand extends UniCommand {
    private static final Logger LOG = Logger.getLogger(ReservationCommand.class);

    @Override
    protected Page performGet(HttpServletRequest request) {
        return new Page(RESERVATION_PAGE);
    }

    @Override
    protected Page performPost(HttpServletRequest request) {


        return new Page("/", true);
    }
}
