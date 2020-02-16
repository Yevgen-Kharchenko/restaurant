package com.restaurant.controller.command.info;

import com.restaurant.controller.command.UniCommand;
import com.restaurant.controller.data.PageResponse;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.RESERVATION_PAGE;

public class ReservationCommand extends UniCommand {

    @Override
    protected PageResponse performGet(HttpServletRequest request) {
        return new PageResponse(RESERVATION_PAGE);
    }

    @Override
    protected PageResponse performPost(HttpServletRequest request) {
        return new PageResponse(RESERVATION_PAGE, true);
    }
}
