package com.restaurant.model;

import com.restaurant.model.enums.Status;
import lombok.*;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Order {
    private long id;
    private LocalDateTime date;
    private double total;
    private long userId;
    private Status status;

}
