package com.restaurant.controller.command.logic;

import com.restaurant.controller.command.Command;
import com.restaurant.controller.command.UniCommand;
import com.restaurant.controller.data.Page;
import com.restaurant.model.enums.DishType;
import com.restaurant.service.InvoiceService;
import com.restaurant.service.OrderService;
import com.restaurant.service.ServiceFactory;
import com.restaurant.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.*;
import static com.restaurant.controller.PageUrlConstants.ORDER_PAGE;

public class InvoiceCommand extends UniCommand {
    private static final Logger LOG = Logger.getLogger(InvoiceCommand.class);

    private InvoiceService invoiceService;
    public static final String ID = "orderId";
    public static final String LOCALE = "locale";


    public InvoiceCommand() {
        this.invoiceService = ServiceFactory.getInvoiceService();

    }

    @Override
    protected Page performGet(HttpServletRequest request) {
        long orderId = Long.parseLong(request.getParameter(ID));
        String local = (String) request.getSession().getAttribute(LOCALE);
        request.setAttribute("invoice", invoiceService.getById(orderId, local));

        return new Page(INVOICE_PAGE);
    }

    @Override
    protected Page performPost(HttpServletRequest request) {


        return new Page("/" + INVOICE_PAGE, false);
    }
}
