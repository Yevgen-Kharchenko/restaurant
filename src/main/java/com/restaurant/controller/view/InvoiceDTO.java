package com.restaurant.controller.view;

import com.restaurant.model.Order;
import com.restaurant.model.User;
import com.restaurant.model.enums.InvoiceStatus;
import com.restaurant.model.enums.Status;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class InvoiceDTO {
    private long id;
    private String date;
    private InvoiceStatus status;
    OrderDTO orderDTO;

}
