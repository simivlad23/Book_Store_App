package view.NotUsed;

import model.notUsed.Account;
import service.NotUsed.AccountService;
import service.NotUsed.PersonSercive;
import service.UserService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditAccountFrame {
    JFrame frameMain = new JFrame("Edit Account");
    JPanel panel = new JPanel();
    JLabel label = new JLabel("idCont");
    JLabel label2 = new JLabel("Sold Nou");


    JTextField tfIdCont = new JTextField();
    JTextField tfSoldNou = new JTextField();





    JButton addAccountBtn = new JButton("EDIT");

    UserService userService;
    PersonSercive personSercive;
    AccountService accountService;


    public EditAccountFrame(UserService userService, AccountService accountService, PersonSercive personSercive) {

        this.userService=userService;
        this.accountService= accountService;
        this.personSercive = personSercive;

        frameMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameMain.setSize(280, 160);
        frameMain.setLocationRelativeTo(null);

        panel.setLayout(null);

        label.setSize(100, 20);
        label.setLocation(20, 20);

        label2.setSize(60, 20);
        label2.setLocation(20, 50);




        tfIdCont.setSize(120, 20);
        tfIdCont.setLocation(100, 20);

        tfSoldNou.setSize(120, 20);
        tfSoldNou.setLocation(100, 50);





        addAccountBtn.setSize(120, 20);
        addAccountBtn.setLocation(60, 90);

        addAccountBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAccount();
            }
        });

        panel.add(label);
        panel.add(label2);


        panel.add(addAccountBtn);
        panel.add(tfIdCont);
        panel.add(tfSoldNou);


        frameMain.setContentPane(panel);
        frameMain.setVisible(true);
    }


    public Long getIdCont() {
        return Long.valueOf(tfIdCont.getText());
    }

    public int getSoldNou() {
        return Integer.valueOf(tfSoldNou.getText());
    }



    public void addAccount() {


        Account account =new Account();
        account.setId(getIdCont());
        account.setMoney(getSoldNou());
        accountService.save(account);



        resetTf();
    }
    public void resetTf(){
        tfSoldNou.setText("");
        tfIdCont.setText("");

    }

}
