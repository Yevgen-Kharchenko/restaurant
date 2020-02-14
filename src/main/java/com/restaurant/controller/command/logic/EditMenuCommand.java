package com.restaurant.controller.command.logic;

import com.restaurant.controller.command.UniCommand;
import com.restaurant.controller.data.PageResponse;
import com.restaurant.service.DishService;
import com.restaurant.service.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static com.google.common.primitives.Ints.tryParse;
import static com.restaurant.controller.PageUrlConstants.EDIT_MENU_PAGE;
import static java.util.Objects.isNull;

public class EditMenuCommand extends UniCommand {
    private static final Logger LOG = Logger.getLogger(EditMenuCommand.class);
    private DishService dishService;

    public static final String LOCALE = "locale";

    public EditMenuCommand() {
        this.dishService = ServiceFactory.getDishService();
    }


    @Override
    protected PageResponse performGet(HttpServletRequest request) {
        String pageStr = request.getParameter("page");
        String sizeStr = request.getParameter("size");
        String local = (String) request.getSession().getAttribute(LOCALE);
        int size;
        int page;
        if (isNull(pageStr)) {
            page = 1;
        } else {
            page = tryParse(pageStr);
        }
        if (isNull(sizeStr)) {
            size = 6;
        } else {
            size = tryParse(sizeStr);
        }
        LOG.info("LOCAL= " + local);
        request.setAttribute("dishList", dishService.getAllPaginated(page, size, local));
        request.setAttribute("currentPage", page);
        request.setAttribute("dishPages", (int) Math.ceil((double) dishService.getAll(local).size() / (double) size));
        LOG.info("DishSize= " + dishService.getAll(local).size());
        LOG.info("dishPages= " + (int) Math.ceil((double) dishService.getAll(local).size() / (double) size));

        return new PageResponse(EDIT_MENU_PAGE);
    }

    @Override
    protected PageResponse performPost(HttpServletRequest request) {


        return new PageResponse("/", true);
    }
}
