package repository;

import model.Order;

import java.util.List;

public interface OrderReository {

    // basics CRUD operations
    Order findById(Long id);

    List<Order> findAll();

    boolean deleteById(Long id);

    Order update(Order order);

    Order create(Order order);
}
