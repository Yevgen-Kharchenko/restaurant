package com.restaurant.model;

import com.restaurant.model.enums.DishType;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Dish {
    private long id;
    private DishType dishType;
    private String nameUK;
    private String nameEN;
    private String ingredientsUK;
    private String ingredientsEN;
    private double price;
    private String imageName;

}
