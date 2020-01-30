package com.restaurant.controller.view;

import com.restaurant.model.enums.DishType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Blob;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class DishDTO {
    private long id;
    private String name;
    private String ingredients;
    private double price;
    private int quantity;
    private DishType dishType;
    private Blob images;

    public DishDTO() {

    }
}
