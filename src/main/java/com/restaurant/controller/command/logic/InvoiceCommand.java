package com.restaurant.controller.command.logic;

import com.restaurant.controller.command.UniCommand;
import com.restaurant.controller.data.PageResponse;
import com.restaurant.service.InvoiceService;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static com.restaurant.controller.PageUrlConstants.INVOICE_PAGE;

@AllArgsConstructor
public class InvoiceCommand extends UniCommand {
    private static final Logger LOG = Logger.getLogger(InvoiceCommand.class);

    private InvoiceService invoiceService;
    public static final String ID = "orderId";
    public static final String LOCALE = "locale";

    @Override
    protected PageResponse performGet(HttpServletRequest request) {
        long orderId = Long.parseLong(request.getParameter(ID));
        String local = (String) request.getSession().getAttribute(LOCALE);
        request.setAttribute("invoice", invoiceService.getById(orderId, local));

        return new PageResponse(INVOICE_PAGE);
    }

    @Override
    protected PageResponse performPost(HttpServletRequest request) {
        long orderId = Long.parseLong(request.getParameter(ID));
        String invoiceStatus = request.getParameter("invoiceStatus");
        String invoiceId = request.getParameter("invoiceId");
        invoiceService.changeInvoiceStatus(invoiceStatus, invoiceId);

        return new PageResponse(INVOICE_PAGE + "?orderId=" + orderId, true);
    }
}
