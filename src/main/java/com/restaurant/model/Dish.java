package com.restaurant.model;

import com.restaurant.model.enums.DishType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Blob;

@ToString
@Getter
@Setter
public class Dish {
    private long id;
    private DishType dishType;
    private String nameUK;
    private String nameEN;
    private String ingredientsUK;
    private String ingredientsEN;
    private double price;
    private Blob images;

    public Dish(long id, DishType dishType, String nameUK, String nameEN, String ingredientsUK, String ingredientsEN, double price, Blob images) {
        this.id = id;
        this.dishType = dishType;
        this.nameUK = nameUK;
        this.nameEN = nameEN;
        this.ingredientsUK = ingredientsUK;
        this.ingredientsEN = ingredientsEN;
        this.price = price;
        this.images = images;
    }

    public Dish(DishType dishType, String nameUK, String nameEN, String ingredientsUK, String ingredientsEN, double price) {
        this.dishType = dishType;
        this.nameUK = nameUK;
        this.nameEN = nameEN;
        this.ingredientsUK = ingredientsUK;
        this.ingredientsEN = ingredientsEN;
        this.price = price;

    }
}
