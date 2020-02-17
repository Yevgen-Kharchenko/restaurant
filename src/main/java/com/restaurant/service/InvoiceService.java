package com.restaurant.service;

import com.restaurant.controller.view.InvoiceDTO;
import com.restaurant.model.Invoice;
import com.restaurant.model.enums.InvoiceStatus;
import com.restaurant.repository.impl.InvoiceDaoImpl;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class InvoiceService {
    private static final Logger LOG = Logger.getLogger(InvoiceService.class);
    private InvoiceDaoImpl invoiceDao;
    private OrderService orderService;

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
        return AllInvoice.stream().map(invoice -> {
            InvoiceDTO invoiceDTO = InvoiceDTO.builder()
                    .id(invoice.getId())
                    .date(invoice.getDate().format(DateTimeFormatter.ofPattern("dd.MM HH:mm")))
                    .status(invoice.getInvoiceStatus())
                    .orderDTO(orderService.getById(invoice.getOrderId(), local))
                    .build();

            return invoiceDTO;
        }).collect(Collectors.toList());

    }

    public void changeInvoiceStatus(String invoiceStatus, String invoiceId) {

        long id = Long.parseLong(invoiceId);
        Invoice invoice = invoiceDao.getById(id);

        if (invoiceStatus.equals("PAID")) {
            orderService.changeStatus("CLOSED", String.valueOf(invoice.getOrderId()));
            invoice.setInvoiceStatus(InvoiceStatus.PAID);
        } else {
            orderService.changeStatus("COMPLETED", String.valueOf(invoice.getOrderId()));
            invoice.setInvoiceStatus(InvoiceStatus.CANCELED);
        }
        invoiceDao.update(invoice);
    }
}
