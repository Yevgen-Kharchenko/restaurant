package com.restaurant.controller.view;

import com.restaurant.model.User;
import com.restaurant.model.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class OrderDTO {
    private long id;
    private LocalDateTime date;
    private double total;
    private User customer;
    private Status status;
    List<DishDTO> orderDish;

}
