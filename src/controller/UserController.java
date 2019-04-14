package controller;

import model.Product;
import service.OrderService;
import service.ProductService;
import service.UserService;
import utils.DataConvertorBook;
import view.UserView;

import java.util.List;

public class UserController {
    private UserView userView;
    private UserService userService;
    private ProductService productService;
    private OrderService orderService;
    private DataConvertorBook dataConvertorBook;

    public UserController(UserView userView,
                          UserService userService,
                          DataConvertorBook dataConvertorBook,
                          OrderService orderService,
                          ProductService productService) {

        this.productService = productService;
        this.orderService = orderService;
        this.userView = userView;
        this.userService = userService;
        this.dataConvertorBook = dataConvertorBook;


        List<Product> productList = productService.getProductRepository().findAll();

        Object[][] itemData = this.dataConvertorBook.bookToTableData(productList);
        String[] itemColumnNames = this.dataConvertorBook.bookToTableColumnNames();


        // set data
        this.userView.refreshProductTable(itemData,itemColumnNames);



        //set action listerner


    }
}
