package com.restaurant.service;

import com.restaurant.controller.view.DishDTO;
import com.restaurant.model.Dish;
import com.restaurant.model.enums.DishType;
import com.restaurant.repository.impl.DishDaoImpl;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class DishService {
    private static final Logger LOG = Logger.getLogger(DishService.class);
    private DishDaoImpl dishDao;

    public Dish getDish(long id) {
        return dishDao.getById(id);
    }

    public List<DishDTO> getAllByField(DishType dishType, String local) {
        List<Dish> all = dishDao.getAllByField(dishType.toString());
        LOG.info("List<Dish> all = " + all.toString());
        return mapToDishDTO(all, local);
    }

    public List<DishDTO> getAllPaginated(int page, int size, String local) {
        List<Dish> all = dishDao.getAllPaginated(page, size);
        return mapToDishDTO(all, local);
    }

    public List<DishDTO> getAll(String local) {
        List<Dish> all = dishDao.getAll();
        return mapToDishDTO(all, local);
    }

    public Dish createDish(DishType dishType, String nameUK, String nameEN, String ingredientsUK,
                           String ingredientsEN, double price, String imageName) {
        Dish createdDish = Dish.builder()
                .dishType(dishType)
                .nameUK(nameUK)
                .nameEN(nameEN)
                .ingredientsUK(ingredientsUK)
                .ingredientsEN(ingredientsEN)
                .price(price)
                .imageName(imageName)
                .build();
        dishDao.create(createdDish);
        return createdDish;
    }

    public Dish updateDish(long id, DishType dishType, String nameUK,
                           String nameEN, String ingredientsUK,
                           String ingredientsEN, double price, String imageName) {
        Dish updatedDish = dishDao.getById(id);
        LOG.info("updeted dish = " + updatedDish);
        updatedDish.setDishType(dishType);
        updatedDish.setNameUK(nameUK);
        updatedDish.setNameEN(nameEN);
        updatedDish.setIngredientsUK(ingredientsUK);
        updatedDish.setIngredientsEN(ingredientsEN);
        updatedDish.setPrice(price);
        updatedDish.setImageName(imageName);

        dishDao.update(updatedDish);
        return updatedDish;
    }

    public void deleteDish(long id) {
        Dish deletedDish = getDish(id);
        dishDao.remove(deletedDish);
    }

    private List<DishDTO> mapToDishDTO(List<Dish> all, String local) {
        return all.stream().map(dish -> {
            DishDTO dishDTO = new DishDTO();
            dishDTO.setId(dish.getId());
            dishDTO.setDishType(dish.getDishType());
            if (local.equals("uk_UA")) {
                dishDTO.setName(dish.getNameUK());
                dishDTO.setIngredients(dish.getIngredientsUK());
            } else {
                dishDTO.setName(dish.getNameEN());
                dishDTO.setIngredients(dish.getIngredientsEN());
            }
            dishDTO.setPrice(dish.getPrice());
            dishDTO.setQuantity(1);
            dishDTO.setImageName(dish.getImageName());
            return dishDTO;
        }).collect(Collectors.toList());
    }
}
