package com.restaurant.model;

import com.restaurant.model.enums.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

@ToString
@Getter
@Setter
public class Order {
    private long id;
    private Date date;
    private double total;
    private long userId;
    private Status status;

    public Order(long id, Date date, double total,
                 long userId, Status status) {
        this.id = id;
        this.date = date;
        this.total = total;
        this.userId = userId;
        this.status = status;
    }

    public Order() {
    }

    public Order(Date date, long userId, Status status) {
        this.date = date;
        this.userId = userId;
        this.status = status;
    }


}
