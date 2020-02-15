package com.restaurant.controller.view;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import com.restaurant.model.enums.DishType;
import lombok.*;

import java.sql.Blob;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
