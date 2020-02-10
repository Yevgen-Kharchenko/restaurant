package com.restaurant.model;

import com.restaurant.model.enums.InvoiceStatus;
import com.restaurant.model.enums.Role;
import com.restaurant.model.enums.Status;
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
