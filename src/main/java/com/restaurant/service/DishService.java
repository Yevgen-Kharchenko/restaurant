package com.restaurant.service;

import com.restaurant.controller.view.DishDTO;
import com.restaurant.model.Dish;
import com.restaurant.model.enums.DishType;
import com.restaurant.repository.DaoFactory;
import com.restaurant.repository.impl.DishDaoImpl;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class DishService {
    private static final Logger LOG = Logger.getLogger(DishService.class);
    private DishDaoImpl dishDao;

    public DishService() {
        this.dishDao = DaoFactory.getDishDao();
    }

    public Dish getDish(long id) {
        return dishDao.getById(id);
    }

    public List<DishDTO> getAllByField(String local, DishType dishType) {
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

    public Dish createDish(DishType dishType, String nameUK, String nameEN, String ingredientsUK, String ingredientsEN, double price) {
        Dish createdDish = new Dish(dishType, nameUK, nameEN, ingredientsUK, ingredientsEN, price);
        dishDao.create(createdDish);
        return createdDish;
    }

    public Dish updateDish(long id, DishType dishType, String nameUK, String nameEN, String ingredientsUK, String ingredientsEN, double price) {
        Dish updatedDish = dishDao.getById(id);
        LOG.info("updeted dish = "+ updatedDish);
        updatedDish.setDishType(dishType);
        updatedDish.setNameUK(nameUK);
        updatedDish.setNameEN(nameEN);
        updatedDish.setIngredientsUK(ingredientsUK);
        updatedDish.setIngredientsEN(ingredientsEN);
        updatedDish.setPrice(price);

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
            dishDTO.setImages(dish.getImages());
            return dishDTO;
        }).collect(Collectors.toList());
    }
}
