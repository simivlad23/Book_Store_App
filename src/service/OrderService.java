package service;

import model.Order;
import repository.OrderReository;

public interface OrderService {

    Order save(Order order);

    public void addOrder(Order order);
    public void removeOrder(Long idOrder);

    public OrderReository getOrderRepository();
}

