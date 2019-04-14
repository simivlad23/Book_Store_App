package view;

import service.NotUsed.AccountService;
import service.NotUsed.PersonSercive;
import service.UserService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteAccountFrame {

    JFrame frameMain = new JFrame("Delete Account");
    JPanel panel = new JPanel();
    JLabel label = new JLabel("idCont De Sters");

    JTextField tfIdCont = new JTextField();


    JButton deleteClientBtn = new JButton("DELETE");

    UserService userService;
    PersonSercive personSercive;
    AccountService accountService;


    public DeleteAccountFrame(UserService userService, AccountService accountService, PersonSercive personSercive) {

        this.userService=userService;
        this.accountService= accountService;
        this.personSercive = personSercive;

        frameMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameMain.setSize(270, 200);
        frameMain.setLocationRelativeTo(null);

        panel.setLayout(null);

        label.setSize(150, 20);
        label.setLocation(40, 20);



        tfIdCont.setSize(120, 20);
        tfIdCont.setLocation(40, 50);


        deleteClientBtn.setSize(120, 30);
        deleteClientBtn.setLocation(40, 90);

        deleteClientBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteAccount();
            }
        });

        panel.add(label);
        panel.add(tfIdCont);
        panel.add(deleteClientBtn);

        frameMain.setContentPane(panel);
        frameMain.setVisible(true);
    }

    public Long getIdCont() {
        return Long.valueOf(tfIdCont.getText());
    }

    public void deleteAccount(){

        accountService.removeAccount(getIdCont());
        resetTf();
    }
    public void resetTf(){
        tfIdCont.setText("");

    }
}
