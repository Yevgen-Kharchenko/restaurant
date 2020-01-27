package com.restaurant.controller.view;

import com.restaurant.model.enums.DishType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.sql.Blob;

@Getter
@Setter
@AllArgsConstructor
public class DishDTO {
    private long id;
    private String name;
    private String ingredients;
    private double price;
    private DishType dishType;
    private Blob images;

    public DishDTO() {

    }
}
