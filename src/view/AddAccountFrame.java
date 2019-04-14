package view;

import model.notUsed.Account;
import service.NotUsed.AccountService;
import service.NotUsed.PersonSercive;
import service.UserService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAccountFrame {

    JFrame frameMain = new JFrame("Add Account");
    JPanel panel = new JPanel();
    JLabel label = new JLabel("idClient");
    JLabel label2 = new JLabel("IBAN");
    JLabel label3 = new JLabel("Sold initial");
    JLabel label4 = new JLabel("Type");

    JTextField tfIdClient = new JTextField();
    JTextField tfIBAN = new JTextField();
    JTextField tfSold= new JTextField();
    String[] comboContent ={"Saving Account","Spending Account"};
    JComboBox<String> typeCombo = new JComboBox<>(comboContent);




    JButton addAccountBtn = new JButton("ADD");


    UserService userService;
    PersonSercive personSercive;
    AccountService accountService;

    public AddAccountFrame(UserService userService, AccountService accountService, PersonSercive personSercive) {


        this.userService=userService;
        this.accountService= accountService;
        this.personSercive = personSercive;

        frameMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameMain.setSize(280, 230);
        frameMain.setLocationRelativeTo(null);

        panel.setLayout(null);

        label.setSize(100, 20);
        label.setLocation(20, 20);

        label2.setSize(60, 20);
        label2.setLocation(20, 50);


        label3.setSize(60, 20);
        label3.setLocation(20, 80);

        label4.setSize(60, 20);
        label4.setLocation(20, 110);





        tfIdClient.setSize(120, 20);
        tfIdClient.setLocation(100, 20);

        tfIBAN.setSize(120, 20);
        tfIBAN.setLocation(100, 50);

        tfSold.setSize(120, 20);
        tfSold.setLocation(100, 80);

        typeCombo.setSize(120, 20);
        typeCombo.setLocation(100, 110);



        addAccountBtn.setSize(120, 20);
        addAccountBtn.setLocation(60, 150);

        addAccountBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAccount();
            }
        });

        panel.add(label);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);

        panel.add(addAccountBtn);
        panel.add(tfIdClient);
        panel.add(tfIBAN);
        panel.add(tfSold);
        panel.add(typeCombo);

        frameMain.setContentPane(panel);
        frameMain.setVisible(true);
    }


    public Long getIdClient() {
        return Long.valueOf(tfIdClient.getText());
    }

    public String getIBAN() {
        return tfIBAN.getText();
    }

    public int getSold() {
        return Integer.valueOf(tfSold.getText());
    }

    public void addAccount() {

        Account account = new Account();
        account.setIban(getIBAN());
        account.setMoney(getSold());
        account.setId_person(getIdClient());


        if(typeCombo.getSelectedIndex()==0)
        {
            System.out.println("Selected "+ typeCombo.getItemAt(0));
            account.setType(typeCombo.getItemAt(0));
            accountService.addAccount(getIdClient(),account);
            //bank.addAccount(getCnpClient(),new SavingAccount(getIdCont(),getSold()));

        }
        else
        {
            System.out.println("Selected "+ typeCombo.getItemAt(1));
            account.setType(typeCombo.getItemAt(1));
            accountService.addAccount(getIdClient(),account);
           // bank.addAccount(getCnpClient(),new SpendingAccount(getIdCont(),getSold()));
        }

        resetTf();
    }
    public void resetTf(){
        tfSold.setText("");
        tfIBAN.setText("");
        tfIdClient.setText("");

    }


}
