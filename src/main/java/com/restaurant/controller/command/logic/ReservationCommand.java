package com.restaurant.controller.command.logic;

import com.restaurant.controller.PageUrlConstants;
import com.restaurant.controller.command.UniCommand;
import com.restaurant.controller.data.PageResponse;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.RESERVATION_PAGE;

public class ReservationCommand extends UniCommand {
    private static final Logger LOG = Logger.getLogger(ReservationCommand.class);

    @Override
    protected PageResponse performGet(HttpServletRequest request) {
        return new PageResponse(RESERVATION_PAGE);
    }

    @Override
    protected PageResponse performPost(HttpServletRequest request) {


        return new PageResponse(RESERVATION_PAGE, true);
    }
}
