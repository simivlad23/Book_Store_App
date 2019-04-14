package service.impl;

import model.Order;
import model.Product;
import repository.OrderReository;
import repository.ProdusRepository;
import service.OrderService;

public class OrderServiceImpl implements OrderService {


    public OrderReository orderReository;
    public ProdusRepository produsRepository;

    public OrderServiceImpl(OrderReository orderReository,ProdusRepository produsRepository) {

        this.orderReository = orderReository;
        this.produsRepository =produsRepository;
    }

    @Override
    public Order save(Order order) {
        if (orderReository.findById(order.getId()) != null) {
            // the order already exist
            // then we make an update
            return orderReository.update(order);
        } else {

            return orderReository.create(order);
        }
    }

    @Override
    public void addOrder(Order order) {

        Product product = produsRepository.findById(order.getIdProd());
        //TODO validation here
        if (product.getQuantity() - order.getCantitate() < 0)
            System.out.println("Soc insuficient");
        else {

            int stoc = product.getQuantity() - order.getCantitate();

            product.setQuantity(stoc);
            produsRepository.update(product);
            orderReository.create(order);
        }

    }

    @Override
    public void removeOrder(Long idOrder) {

        orderReository.deleteById(idOrder);
    }

    @Override
    public OrderReository getOrderRepository() {
        return orderReository;
    }
}
