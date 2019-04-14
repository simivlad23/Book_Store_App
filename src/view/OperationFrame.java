package view;

import service.NotUsed.AccountService;
import service.NotUsed.PersonSercive;
import service.UserService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperationFrame {

    JFrame frameMain = new JFrame("Operations");
    JPanel panel = new JPanel();
    JLabel label = new JLabel("IBAN Cont");
    JLabel label2 = new JLabel("Suma");
    JLabel label3 = new JLabel("IBAN Cont destinatar");

    JTextField tfIdCont = new JTextField();
    JTextField tfSuma = new JTextField();
    JTextField tfIdContDest = new JTextField();

    JButton addDepozitBtn = new JButton("Deposit");
    JButton addRetragreBtn = new JButton("Withdraw");
    JButton addTransferBtn = new JButton("Transfer");

    UserService userService;
    PersonSercive personSercive;
    AccountService accountService;

    public OperationFrame(UserService userService, AccountService accountService, PersonSercive personSercive) {

        this.userService=userService;
        this.accountService= accountService;
        this.personSercive = personSercive;

        frameMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameMain.setSize(280, 260);
        frameMain.setLocationRelativeTo(null);

        panel.setLayout(null);

        label.setSize(100, 20);
        label.setLocation(20, 20);

        label2.setSize(60, 20);
        label2.setLocation(20, 50);

        label3.setSize(60, 20);
        label3.setLocation(20, 80);




        tfIdCont.setSize(120, 20);
        tfIdCont.setLocation(100, 20);

        tfSuma.setSize(120, 20);
        tfSuma.setLocation(100, 50);

        tfIdContDest.setSize(120, 20);
        tfIdContDest.setLocation(100, 80);

        addDepozitBtn.setSize(100, 20);
        addDepozitBtn.setLocation(10, 120);

        addRetragreBtn.setSize(100, 20);
        addRetragreBtn.setLocation(120, 120);

        addTransferBtn.setSize(100, 20);
        addTransferBtn.setLocation(70, 170);

        addDepozitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDepozit();
            }
        });

        addRetragreBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addWithdraw();
            }
        });
        addTransferBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transfer();
            }
        });

        panel.add(label);
        panel.add(label2);
        panel.add(label3);

        panel.add(addDepozitBtn);
        panel.add(addRetragreBtn);
        panel.add(addTransferBtn);
        panel.add(tfIdCont);
        panel.add(tfSuma);
        panel.add(tfIdContDest);
        frameMain.setContentPane(panel);
        frameMain.setVisible(true);
    }



    public String getIdCont() {
        return tfIdCont.getText();
    }

    public int getSuma() {
        return Integer.valueOf(tfSuma.getText());
    }
    public String getIdContDest() {
        return tfIdContDest.getText();
    }
    public void addDepozit() {


        accountService.deposit(getIdCont(),getSuma());

       resetTf();

    }
    public void addWithdraw()
    {

        accountService.withdraw(getIdCont(),getSuma());

        resetTf();

    }
    public  void transfer()
    {
accountService.transfer(getIdCont(),getIdContDest(),getSuma());

    }
    public void resetTf(){
        tfSuma.setText("");
        tfIdCont.setText("");

    }

}
