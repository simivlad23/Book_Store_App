package view;

import model.User;
import service.NotUsed.AccountService;
import service.NotUsed.PersonSercive;
import service.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener {



    private static final int WIDTH = 400;
    private static final int HEIGHT = 500;
    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");
    UserService userService;
    PersonSercive personSercive;
    AccountService accountService;

    // form here we deleted the other service Class which allows us to make CRUD operations
    public LoginFrame(UserService userService) {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        this.userService=userService;
        this.accountService= accountService;
        this.personSercive = personSercive;
        setLocation(450,150);
        this.setSize(WIDTH,HEIGHT);



    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);


    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == loginButton) {

            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();

            System.out.println("");

            User user = userService.login(userText,pwdText);


            if (user!=null) {
                JOptionPane.showMessageDialog(this, "Login Successful");

                this.setVisible(false);
                if(user.isAdmin())
                {
                   AdminFrame adminFrame = new AdminFrame();

                    //TODO Admin Window;
                }
                else {

                    UserView regularUserFrame = new UserView();
                    regularUserFrame.setTitle("BOOK Store");
                    regularUserFrame.setVisible(true);

                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }

        }
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
        //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }


        }
    }

}



