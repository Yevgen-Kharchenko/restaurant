package com.restaurant.model;

import com.restaurant.model.enums.Status;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@ToString
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Order {
    private long id;
    private LocalDateTime date;
    private double total;
    private long userId;
    private Status status;

}
