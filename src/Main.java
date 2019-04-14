import model.Product;
import repository.OrderReository;
import repository.ProdusRepository;
import repository.UserRepository;
import repository.impl.JDBConnectionWrapper;
import repository.impl.OrderRepositoryImpl;
import repository.impl.ProdusRepositoryImpl;
import repository.impl.UserRepositoryImpl;
import service.OrderService;
import service.ProductService;
import service.UserService;
import service.impl.OrderServiceImpl;
import service.impl.ProductServiceImpl;
import service.impl.UserServiceImpl;
import view.UserView;

public class Main {
    public static void main(String[] args) {
        JDBConnectionWrapper jdbConnectionWrapper = new JDBConnectionWrapper("bookstore");

        // here we initialize repo
        UserRepository userRepository = new UserRepositoryImpl(jdbConnectionWrapper);
        ProdusRepository produsRepository = new ProdusRepositoryImpl(jdbConnectionWrapper);
        OrderReository orderReository = new OrderRepositoryImpl(jdbConnectionWrapper);




        // here we initialize repo
        //TODO i have to create also service class for all repository
        UserService userService = new UserServiceImpl(userRepository);
        ProductService productService = new ProductServiceImpl(produsRepository);
        OrderService orderService = new OrderServiceImpl(orderReository,produsRepository);


        //TODO testat product repository methods
        //TODO to test the order repository methods

     /*   User user = new User();
        // user.setId(1L);
        user.setUsername("u");
        user.setPassword("p");
        user.setAdmin(false);

        userService.save(user);*/

        Product product = new Product("1243","ceva 2","df45","asd",25,100);


        productService.save(product);
       //produsRepository(product);

        //Order order = new Order(2L,10);

        //orderService.addOrder(order);


        UserView userView = new UserView();
        userView.setVisible(true);




       //  LoginFrame frame = new LoginFrame(userService,accountService,personSercive);
       /* LoginFrame frame = new LoginFrame(userService);

        frame.setTitle("Login Form");
        frame.setVisible(true);

        frame.setBounds(500, 50, 400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);*/
    }
}
