package com.restaurant.controller.view;

import com.restaurant.model.Dish;
import com.restaurant.model.User;
import com.restaurant.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class OrderDTO {
    private long id;
    private Date date;
    private double total;
    private User customer;
    private Status status;
    List<DishDTO> orderDish;

    public OrderDTO() {
    }
}
