package com.restaurant.controller.view;

import com.restaurant.model.enums.DishType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DishDTO {
    private long id;
    private String name;
    private String ingredients;
    private double price;
    private int quantity;
    private double cost;
    private DishType dishType;
    private String imageName;

}
