package com.restaurant.service;

import com.restaurant.controller.view.DishDTO;
import com.restaurant.model.Dish;
import com.restaurant.model.enums.DishType;
import com.restaurant.repository.impl.DishDaoImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DishServiceTest {
    private DishDaoImpl dishDao = mock(DishDaoImpl.class);
    private DishService dishService;
    private List<Dish> dishes = new ArrayList<>();
    private Dish dish;

    @Before
    public void init() {
        dishService = new DishService(dishDao);
        dishes.add(Dish.builder().id(1L).price(50.0).build());
        dishes.add(Dish.builder().id(2L).price(10.0).build());
        dish = Dish.builder().id(3L).price(12.0).build();
    }

    @Test
    public void getDish() {
        when(dishDao.getById(anyLong())).thenReturn(dish);
        assertEquals(dishService.getDish(3), dish);
    }

    @Test
    public void getAllByField() {
        when(dishDao.getAllByField(anyString())).thenReturn(dishes);
        List<DishDTO> receivedDish = dishService.getAllByField(DishType.DRINKS, "uk");
        assertEquals(2, receivedDish.size());
    }

    @Test
    public void getAllPaginated() {
        when(dishDao.getAllPaginated(anyInt(), anyInt())).thenReturn(dishes);
        List<DishDTO> receivedDish = dishService.getAllPaginated(1, 3, "uk");
        assertEquals(2, receivedDish.size());
    }

    @Test
    public void getAll() {
        when(dishDao.getAll()).thenReturn(dishes);
        List<DishDTO> receivedDish = dishService.getAll("uk");
        assertEquals(2, receivedDish.size());
    }

    @Test
    public void createDish() {
        when(dishDao.create(anyObject())).thenReturn(dish);
        Dish receivedDish = dishService.createDish(DishType.MAIN, "nameUK", "nameEN",
                "ingredientsUk", "ingredientsEN", 20.2, "dish-1.jpg");
        assertEquals(receivedDish, dish);
    }

    @Test
    public void updateDish() {
    }

    @Test
    public void deleteDish() {
    }
}
