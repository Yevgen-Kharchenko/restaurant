package com.restaurant.service;

import com.restaurant.controller.view.InvoiceDTO;
import com.restaurant.model.Invoice;
import com.restaurant.model.enums.InvoiceStatus;
import com.restaurant.repository.DaoFactory;
import com.restaurant.repository.impl.InvoiceDaoImpl;
import org.apache.log4j.Logger;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class InvoiceService {
    private static final Logger LOG = Logger.getLogger(InvoiceService.class);
    private InvoiceDaoImpl invoiceDao;
    private OrderService orderService;

    public InvoiceService() {
        this.invoiceDao = DaoFactory.getInvoiceDao();
        this.orderService = new OrderService();
    }

    public void createInvoice(String id) {
        long orderId = Long.parseLong(id);
        LocalDateTime date = LocalDateTime.now().withNano(0);
        Invoice invoice = Invoice.builder()
                .date(date)
                .orderId(orderId)
                .invoiceStatus(InvoiceStatus.NEW)
                .build();
        invoice = invoiceDao.create(invoice);
        LOG.info("invoice create : " + invoice.toString());
    }

    public List<InvoiceDTO> getById(long id, String local) {
        List<Invoice> AllInvoice = invoiceDao.getAllByFieldId(id);
        return  AllInvoice.stream().map(invoice ->{
            InvoiceDTO invoiceDTO = new InvoiceDTO(invoice.getId(),
                    invoice.getDate(),invoice.getInvoiceStatus(),
                    orderService.getById(invoice.getOrderId(),local));
            return invoiceDTO;
        }).collect(Collectors.toList());

    }

//
//    public List<DishDTO> getAllByField(DishType dishType, String local) {
//        List<Dish> all = invoiceDao.getAllByField(dishType.toString());
//        LOG.info("List<Dish> all = " + all.toString());
//        return mapToDishDTO(all, local);
//    }
//
//    public List<DishDTO> getAllPaginated(int page, int size, String local) {
//        List<Dish> all = invoiceDao.getAllPaginated(page, size);
//        return mapToDishDTO(all, local);
//    }
//
//    public List<DishDTO> getAll(String local) {
//        List<Dish> all = invoiceDao.getAll();
//        return mapToDishDTO(all, local);
//    }
//
//    public Dish createDish(DishType dishType, String nameUK, String nameEN, String ingredientsUK, String ingredientsEN, double price) {
//        Dish createdDish = Dish.builder()
//                .dishType(dishType)
//                .nameUK(nameUK)
//                .nameEN(nameEN)
//                .ingredientsUK(ingredientsUK)
//                .ingredientsEN(ingredientsEN)
//                .price(price)
//                .build();
//        invoiceDao.create(createdDish);
//        return createdDish;
//    }
//
//    public Dish updateDish(long id, DishType dishType, String nameUK, String nameEN, String ingredientsUK, String ingredientsEN, double price) {
//        Dish updatedDish = invoiceDao.getById(id);
//        LOG.info("updeted dish = " + updatedDish);
//        updatedDish.setDishType(dishType);
//        updatedDish.setNameUK(nameUK);
//        updatedDish.setNameEN(nameEN);
//        updatedDish.setIngredientsUK(ingredientsUK);
//        updatedDish.setIngredientsEN(ingredientsEN);
//        updatedDish.setPrice(price);
//
//        invoiceDao.update(updatedDish);
//        return updatedDish;
//    }
//
//    public void deleteDish(long id) {
//        Dish deletedDish = getDish(id);
//        invoiceDao.remove(deletedDish);
//    }
//
//    private List<DishDTO> mapToDishDTO(List<Dish> all, String local) {
//        return all.stream().map(dish -> {
//            DishDTO dishDTO = new DishDTO();
//            dishDTO.setId(dish.getId());
//            dishDTO.setDishType(dish.getDishType());
//            if (local.equals("uk_UA")) {
//                dishDTO.setName(dish.getNameUK());
//                dishDTO.setIngredients(dish.getIngredientsUK());
//            } else {
//                dishDTO.setName(dish.getNameEN());
//                dishDTO.setIngredients(dish.getIngredientsEN());
//            }
//            dishDTO.setPrice(dish.getPrice());
//            dishDTO.setQuantity(1);
//            dishDTO.setImages(dish.getImages());
//            return dishDTO;
//        }).collect(Collectors.toList());
//    }
}
