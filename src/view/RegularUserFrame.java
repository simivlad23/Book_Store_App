package view;

import service.NotUsed.AccountService;
import service.NotUsed.PersonSercive;
import service.UserService;
import utils.DataConverter;
import utils.DataConvertorPerson;
import utils.impl.DataConverterImpl;
import utils.impl.DataConvertorPersonImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegularUserFrame extends JFrame implements ActionListener{

    JFrame frameMain = new JFrame("<SimionBank>");
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Persons");
    JLabel label2 = new JLabel("Accounts");
    JButton addClientBtn = new JButton("ADD");
    JButton addAccountBtn = new JButton("ADD");
    JButton editClientBtn = new JButton("EDIT");
    JButton editAccountBtn = new JButton("EDIT");
    JButton deleteClientBtn = new JButton("DELETE");
    JButton deleteAccoutBtn = new JButton("DELETE");
    JButton viewClientBtn = new JButton("VIEW");
    JButton viewAccountBtn = new JButton("VIEW");
    JButton operationsBtn = new JButton("OPERATIONS");

    UserService userService;
    PersonSercive personSercive;
    AccountService accountService;



    public RegularUserFrame(UserService userService, AccountService accountService, PersonSercive personSercive) {

        this.userService=userService;
        this.accountService= accountService;
        this.personSercive = personSercive;

        addActionEvent();

        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.setSize(380, 300);
        frameMain.setLocation(500,20);
       // frameMain.setLocationRelativeTo(null);

        panel.setLayout(null);

        label.setSize(60, 20);
        label.setLocation(60, 15);

        label2.setSize(60, 20);
        label2.setLocation(230, 15);

        addClientBtn.setSize(120, 20);
        addClientBtn.setLocation(20, 50);

        editClientBtn.setSize(120, 20);
        editClientBtn.setLocation(20, 80);

        deleteClientBtn.setSize(120, 20);
        deleteClientBtn.setLocation(20, 110);

        viewClientBtn.setSize(120, 20);
        viewClientBtn.setLocation(20, 140);
//----------------------------------------------------------

        addAccountBtn.setSize(120, 20);
        addAccountBtn.setLocation(200, 50);

        editAccountBtn.setSize(120, 20);
        editAccountBtn.setLocation(200, 80);

        deleteAccoutBtn.setSize(120, 20);
        deleteAccoutBtn.setLocation(200, 110);


        viewAccountBtn.setSize(120, 20);
        viewAccountBtn.setLocation(200, 140);

        operationsBtn.setSize(120, 30);
        operationsBtn.setLocation(115, 180);


        panel.add(label);
        panel.add(label2);
        panel.add(addClientBtn);
        panel.add(addAccountBtn);
        panel.add(editClientBtn);
        panel.add(editAccountBtn);
        panel.add(deleteClientBtn);
        panel.add(deleteAccoutBtn);
        panel.add(viewClientBtn);
        panel.add(viewAccountBtn);
        panel.add(operationsBtn);
        frameMain.setContentPane(panel);
        frameMain.setVisible(true);
    }



    public void addActionEvent() {
        addAccountBtn.addActionListener(this);
        addClientBtn.addActionListener(this);
        editAccountBtn.addActionListener(this);
        editClientBtn.addActionListener(this);
        deleteAccoutBtn.addActionListener(this);
        deleteClientBtn.addActionListener(this);
        viewAccountBtn.addActionListener(this);
        viewClientBtn.addActionListener(this);
        operationsBtn.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Coding Part of LOGIN button

        if (e.getSource() == viewAccountBtn) {
            DataConverter dataConverter = new DataConverterImpl();
            ViewAccountFrame viewAccountFrame = new ViewAccountFrame(accountService.getAccountRepository(),dataConverter);
        }
        if (e.getSource() == viewClientBtn) {
            DataConvertorPerson dataConverterP = new DataConvertorPersonImpl();
            ViewClientFrame viewClientFrame = new ViewClientFrame(personSercive.getPersonRepository(),dataConverterP);
        }

        if (e.getSource() == editClientBtn) {
            DataConvertorPerson dataConverterP = new DataConvertorPersonImpl();
            EditClientFrame editClientFrame = new EditClientFrame(userService,accountService,personSercive);
        }
        if (e.getSource() == editAccountBtn) {
            DataConvertorPerson dataConverterP = new DataConvertorPersonImpl();
            EditAccountFrame editAccountFrame = new EditAccountFrame(userService,accountService,personSercive);
        }
        if (e.getSource() == deleteClientBtn) {
            DataConvertorPerson dataConverterP = new DataConvertorPersonImpl();
            DeleteClientFrame deleteClientFrame = new DeleteClientFrame(userService,accountService,personSercive);
        }
        if (e.getSource() == deleteAccoutBtn) {
            DataConvertorPerson dataConverterP = new DataConvertorPersonImpl();
            DeleteAccountFrame deleteAccountFrame = new DeleteAccountFrame(userService,accountService,personSercive);
        }
        if (e.getSource() == addClientBtn) {
            DataConvertorPerson dataConverterP = new DataConvertorPersonImpl();
            AddClientFrame addClientFrame = new AddClientFrame(userService,accountService,personSercive);
        }
        if (e.getSource() == addAccountBtn) {
            DataConvertorPerson dataConverterP = new DataConvertorPersonImpl();
            AddAccountFrame addAccountFrame = new AddAccountFrame(userService,accountService,personSercive);
        }
        if (e.getSource() == operationsBtn) {
            DataConvertorPerson dataConverterP = new DataConvertorPersonImpl();
            OperationFrame operationFrame = new OperationFrame(userService,accountService,personSercive);
        }

    }
}
