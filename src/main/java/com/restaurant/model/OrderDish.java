package com.restaurant.model;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class OrderDish {
    private long id;
    private long orderId;
    private long dishId;
    private int quantity;
    private String nameUK;
    private String nameEN;
    private String ingredientsUK;
    private String ingredientsEN;
    private double price;

}
