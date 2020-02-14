package com.restaurant.controller.command.logic;

import com.restaurant.controller.command.UniCommand;
import com.restaurant.controller.data.PageResponse;
import com.restaurant.service.InvoiceService;
import com.restaurant.service.OrderService;
import com.restaurant.service.ServiceFactory;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import static com.restaurant.controller.PageUrlConstants.CHEF_PAGE;

public class StatusCommand extends UniCommand {
    private static final Logger LOG = Logger.getLogger(StatusCommand.class);
    private OrderService orderService;
    private InvoiceService invoiceService;

    public StatusCommand() {
        this.orderService = ServiceFactory.getOrderService();
        this.invoiceService = ServiceFactory.getInvoiceService();
    }

    @Override
    protected PageResponse performGet(HttpServletRequest request) {
        return new PageResponse(CHEF_PAGE,true);
    }

    @Override
    protected PageResponse performPost(HttpServletRequest request) {

        String status = request.getParameter("status");
        String orderId = request.getParameter("orderId");
        String originUrl = request.getHeader("referer");
        LOG.info("Post status: " + status);
        if (status.equals("REPEAT")) {
            orderService.repeatOrder(orderId);
        }else if (status.equals("PAYMENT")){
            invoiceService.createInvoice(orderId);
            orderService.changeStatus(status, orderId);
        }else {
            orderService.changeStatus(status, orderId);
            request.setAttribute("notification", "Order status changed!");
            LOG.info("status : " + status);
        }
        return new PageResponse(originUrl,true);
    }
}
