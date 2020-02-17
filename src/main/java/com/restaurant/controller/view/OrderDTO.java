package com.restaurant.controller.view;

import com.restaurant.model.User;
import com.restaurant.model.enums.Status;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
@EqualsAndHashCode
public class OrderDTO {
    private long id;
    private String date;
    private double total;
    private User customer;
    private Status status;
    private List<DishDTO> orderDish;

}
