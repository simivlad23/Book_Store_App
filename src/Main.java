import controller.LoginController;
import controller.UserController;
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
import utils.DataConvertorBook;
import utils.impl.DataConverterIBookImpl;
import view.AdminFrame;
import view.LoginFrame;
import view.UserView;

public class Main {

    private static DataConvertorBook dataConvertorBook;
    private static UserService userService;
    private static ProductService productService;
    private static OrderService orderService;
    //private static ContextHolder contextHolder;
    private static LoginController loginController;
    private static UserView userView;
    private static AdminFrame adminFrame;



    public static void main(String[] args) {
        JDBConnectionWrapper jdbConnectionWrapper = new JDBConnectionWrapper("bookstore");


        dataConvertorBook = new DataConverterIBookImpl();
        // here we initialize repo
        UserRepository userRepository = new UserRepositoryImpl(jdbConnectionWrapper);
        ProdusRepository produsRepository = new ProdusRepositoryImpl(jdbConnectionWrapper);
        OrderReository orderReository = new OrderRepositoryImpl(jdbConnectionWrapper);


        // here we initialize service
        //TODO i have to create also service class for all repository
        userService = new UserServiceImpl(userRepository);
        productService = new ProductServiceImpl(produsRepository);
        orderService = new OrderServiceImpl(orderReository, produsRepository);




        //TODO testat product repository methods
        //TODO to test the order repository methods

     /*   User user = new User();
        // user.setId(1L);
        user.setUsername("u");
        user.setPassword("p");
        user.setAdmin(false);

        userService.save(user);*/

        //Product product = new Product("1243","ceva 2","df45","asd",25,100);


        // productService.save(product);
        //produsRepository(product);

        //Order order = new Order(2L,10);

        //orderService.addOrder(order);


//        UserView userView = new UserView();
//        userView.setVisible(true);



        /*LoginFrame frame = new LoginFrame();
        LoginController loginController = new LoginController(frame,userService);
*/
        openLogin();

    }


    public static void openUserView() {
        UserController userController = new UserController(new UserView(),userService,dataConvertorBook,orderService,productService);
    }

    public static void openLogin() {
        LoginController loginView = new LoginController(new LoginFrame(),userService,dataConvertorBook,orderService,productService);
    }

}
