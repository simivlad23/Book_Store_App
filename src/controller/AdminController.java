package controller;

import service.OrderService;
import service.ProductService;
import service.UserService;
import view.AdminFrame;

public class AdminController {
    private AdminFrame adminFrame;
    private ProductService productService;
    private OrderService orderService;
    private UserService userService;

    public AdminController(AdminFrame adminFrame, ProductService productService, OrderService orderService, UserService userService) {
        this.adminFrame = adminFrame;
        this.productService = productService;
        this.orderService = orderService;
        this.userService = userService;
    }

}
