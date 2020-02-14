package com.restaurant.service;

import com.restaurant.controller.view.InvoiceDTO;
import com.restaurant.model.Invoice;
import com.restaurant.model.enums.InvoiceStatus;
import com.restaurant.repository.DaoFactory;
import com.restaurant.repository.impl.InvoiceDaoImpl;
import org.apache.log4j.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class InvoiceService {
    private static final Logger LOG = Logger.getLogger(InvoiceService.class);
    private InvoiceDaoImpl invoiceDao;
    private OrderService orderService;

    public InvoiceService() {
        this.invoiceDao = DaoFactory.getInvoiceDao();
        this.orderService = new OrderService();
    }

    public void createInvoice(String id) {
        long orderId = Long.parseLong(id);
        LocalDateTime date = LocalDateTime.now().withNano(0);
        Invoice invoice = Invoice.builder()
                .date(date)
                .orderId(orderId)
                .invoiceStatus(InvoiceStatus.NEW)
                .build();
        invoice = invoiceDao.create(invoice);
        LOG.info("invoice create : " + invoice.toString());
    }

    public List<InvoiceDTO> getById(long id, String local) {
        List<Invoice> AllInvoice = invoiceDao.getAllByFieldId(id);
        return  AllInvoice.stream().map(invoice ->{
            InvoiceDTO invoiceDTO = new InvoiceDTO(invoice.getId(),
                    invoice.getDate().format(DateTimeFormatter.ofPattern("dd.MM HH:mm")),
                    invoice.getInvoiceStatus(),
                    orderService.getById(invoice.getOrderId(),local));
            return invoiceDTO;
        }).collect(Collectors.toList());

    }

    public void changeInvoiceStatus(String invoiceStatus, String invoiceId) {
        Long id = Long.parseLong(invoiceId);

        Invoice invoice = invoiceDao.getById(id);

        if (invoiceStatus.equals("PAID")) {
            orderService.changeStatus("CLOSED", String.valueOf(invoice.getOrderId()));
            invoice.setInvoiceStatus(InvoiceStatus.PAID);
            invoiceDao.update(invoice);
        }else {
            orderService.changeStatus("COMPLETED", String.valueOf(invoice.getOrderId()));
            invoice.setInvoiceStatus(InvoiceStatus.CANCELED);
            invoiceDao.update(invoice);
        }

    }
}
