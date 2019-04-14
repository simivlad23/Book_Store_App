package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame  {



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


    // form here we deleted the other service Class which allows us to make CRUD operations
    public LoginFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();

        setLocation(450,150);
        this.setSize(WIDTH,HEIGHT);

        this.setVisible(true);


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




    public void addLoginActionListener(ActionListener listener) {
        System.out.println("A ajuns aici");
        loginButton.addActionListener(listener);
    }

    public void addResetActionListener(ActionListener listener) {
        resetButton.addActionListener(listener);
    }
    public void addShowPassActionListener(ActionListener listener) {
        resetButton.addActionListener(listener);
    }



       /* //Coding Part of RESET button
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
    */

    public JCheckBox getShowPassword() {
        return showPassword;
    }

    public String getUsermane()
    {
        return userTextField.getText();
    }
    public String getPassword()
    {
        return passwordField.getText();
    }

    public JTextField getUserTextField() {
        return userTextField;
    }

    public void setUserTextField(JTextField userTextField) {
        this.userTextField = userTextField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }
}



