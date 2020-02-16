package com.restaurant.controller.view;

import com.restaurant.model.enums.InvoiceStatus;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
public class InvoiceDTO {
    private long id;
    private String date;
    private InvoiceStatus status;
    private OrderDTO orderDTO;

}
