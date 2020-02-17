package com.restaurant.service;

import com.restaurant.config.transaction.TransactionHandler;
import com.restaurant.controller.view.OrderDTO;
import com.restaurant.model.Invoice;
import com.restaurant.model.enums.InvoiceStatus;
import com.restaurant.repository.impl.InvoiceDaoImpl;
import com.restaurant.repository.impl.OrderDaoImpl;
import com.restaurant.repository.impl.OrderDishDaoImpl;
import com.restaurant.repository.impl.UserDaoImpl;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

public class InvoiceServiceTest {
    private InvoiceService invoiceService;
    private InvoiceDaoImpl invoiceDao = mock(InvoiceDaoImpl.class);
    private OrderService orderService = mock(OrderService.class);
    private OrderDaoImpl orderDao = mock(OrderDaoImpl.class);
    private UserDaoImpl userDao = mock(UserDaoImpl.class);
    private OrderDishDaoImpl orderDishDao = mock(OrderDishDaoImpl.class);
    private TransactionHandler transactionHandler = mock(TransactionHandler.class);

    private List<Invoice> invoices = new ArrayList<>();
    private Invoice invoice;
    private OrderDTO orderDTO;


    @Before
    public void init() {
        invoiceService = new InvoiceService(invoiceDao, orderService);
        orderService = new OrderService(orderDao, userDao, orderDishDao, transactionHandler);
        invoices.add(Invoice.builder().id(1L).date(LocalDateTime.now()).orderId(1L).invoiceStatus(InvoiceStatus.NEW).build());
        invoices.add(Invoice.builder().id(2L).date(LocalDateTime.now()).orderId(2L).invoiceStatus(InvoiceStatus.PAID).build());
        invoice = Invoice.builder().id(3L).date(LocalDateTime.now()).orderId(3L).invoiceStatus(InvoiceStatus.CANCELED).build();
        orderDTO = OrderDTO.builder().id(5l).build();

    }

    @Test
    public void createInvoice() {
    }

    @Test
    public void getById() {
//        when(invoiceDao.getAllByFieldId(anyLong())).thenReturn(invoices);
//        when(orderService.getById(anyLong(), anyString())).thenReturn(orderDTO);
//        List<InvoiceDTO> receivedInvoice = invoiceService.getById(1, "uk");
//        assertEquals(2, receivedInvoice.size());
    }

    @Test
    public void changeInvoiceStatus() {
    }
}
