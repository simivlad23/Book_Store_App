package controller;

import model.Product;
import service.OrderService;
import service.ProductService;
import service.UserService;
import utils.DataConvertorBook;
import view.UserView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        // o posibilitae de facut search pe baza de date si pe podus e sa culegem toate produsele din baza de date
        // si apoi sa facem cu forEach pe list nostra si in finctie de campurile completate sa afisam rezultatele
        // sau sa afisam un mesaj de eroare in caz canu avem cartea respectia
        //TODO De facut lamda expresion

        Object[][] itemData = this.dataConvertorBook.bookToTableData(productList);
        String[] itemColumnNames = this.dataConvertorBook.bookToTableColumnNames();


        // set data
        this.userView.refreshProductTable(itemData, itemColumnNames);


        //set action listerner
        this.userView.addSearchActionListener(new SearchActionListener());
        this.userView.addSellActionListener(new SellActionListener());


    }


    private class SellActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            //TODO serch part here using productService and the fields form UI
            String isbnProdus = userView.getIsbnSell().getText();
            int cantitate = (Integer) userView.getSpinner().getValue();
            //validam daca putem intregistra comanda
            Product product = productService.getProductRepository().findByISBN(isbnProdus);
            if (product != null) {
                if (product.getQuantity() - cantitate < 0) {
                    JOptionPane.showMessageDialog(userView, "Stoc Insuficient");
                    System.out.println("Soc insuficient");
                } else {
                    int stoc = product.getQuantity() - cantitate;
                    product.setQuantity(stoc);
                    productService.subStok(product);
                    //TODO after a sub we can implemant observer pattern to refresh the UI aftre observeble Model is modificated

                    userView.getIsbnSell().setText("");
                    userView.getSpinner().setValue(0);
                    JOptionPane.showMessageDialog(userView, "Vanzare cu Succes");
                }


            }
        }
    }

    private class SearchActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //TODO sell part using productSevice  and also orderSevice
            // TODO and also here will validate the data;
            System.out.println("Search a fost apelat");
        }
    }

}
