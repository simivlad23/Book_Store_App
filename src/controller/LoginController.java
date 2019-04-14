package controller;

import model.User;
import service.UserService;
import view.AdminFrame;
import view.LoginFrame;
import view.UserView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    private final UserService userService;
    LoginFrame loginFrame;

    // putem sa trimitem ca si parametru si un data convertor

    public LoginController(LoginFrame loginView, UserService userService) {

        this.userService = userService;
        this.loginFrame = loginView;
        // TODO alte servivi de asignat aici


        // aici am adaugar listener pentru butoane
        this.loginFrame.addLoginActionListener(new LoginActionListener());
        this.loginFrame.addResetActionListener(new ResetActionListener());
        this.loginFrame.addShowPassActionListener(new ShowPassActionListener());


        //culegem date din model (service, etc)
        //mapari de obiecte

        //populam UI-ul
    }

    //cate o clasa privata care implementeaza
    //ActionListener pentru fiecare buton
    private class LoginActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String userText;
            String pwdText;
            userText = loginFrame.getUsermane();
            pwdText = loginFrame.getPassword();

            System.out.println(userText +" "+ pwdText);

            User user = userService.login(userText,pwdText);


            if (user!=null) {
                JOptionPane.showMessageDialog(loginFrame, "Login Successful");

                loginFrame.setVisible(false);
                if(user.isAdmin())
                {
                    System.out.println("Logare ca si Admin");
                    AdminFrame adminFrame = new AdminFrame();
                    //AdminController adminController = new AdminController();

                }
                else {


                    System.out.println("Logare ca regular User");
                    UserView regularUserFrame = new UserView();
                    UserController userController = new UserController(regularUserFrame,userService);


                }
            } else {
                JOptionPane.showMessageDialog(loginFrame, "Invalid Username or Password");
            }
        }
    }
    private class ResetActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            loginFrame.getPasswordField().setText("");
            loginFrame.getUserTextField().setText("");
        }
    }
    private class ShowPassActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            //TODO Nu merge partea de show password
            if (loginFrame.getShowPassword().isSelected()) {
                loginFrame.getPasswordField().setEchoChar((char) 0);
            } else {
                loginFrame.getPasswordField().setEchoChar('*');
            }
        }
    }

    //metode private ajutatoare

}
