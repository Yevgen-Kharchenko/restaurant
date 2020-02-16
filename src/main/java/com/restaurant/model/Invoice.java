package com.restaurant.model;

import com.restaurant.model.enums.InvoiceStatus;
import lombok.*;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Invoice {
    private long id;
    private LocalDateTime date;
    private long orderId;
    private InvoiceStatus invoiceStatus;

}
