package view.NotUsed;

import service.NotUsed.AccountService;
import service.NotUsed.PersonSercive;
import service.UserService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteClientFrame extends JFrame{
    JFrame frameMain = new JFrame("Delete Person");
    JPanel panel = new JPanel();
    JLabel label = new JLabel("CNP Client De Sters");

    JTextField tfNume = new JTextField();


    JButton deleteClientBtn = new JButton("DELETE");

    UserService userService;
    PersonSercive personSercive;
    AccountService accountService;


    public DeleteClientFrame(UserService userService, AccountService accountService, PersonSercive personSercive) {

        this.userService=userService;
        this.accountService= accountService;
        this.personSercive = personSercive;

        frameMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameMain.setSize(270, 200);
        frameMain.setLocationRelativeTo(null);

        panel.setLayout(null);

        label.setSize(150, 20);
        label.setLocation(40, 20);



        tfNume.setSize(120, 20);
        tfNume.setLocation(40, 50);


        deleteClientBtn.setSize(120, 30);
        deleteClientBtn.setLocation(40, 90);

        deleteClientBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteClient();
            }
        });

        panel.add(label);
        panel.add(tfNume);
        panel.add(deleteClientBtn);

        frameMain.setContentPane(panel);
        frameMain.setVisible(true);
    }

    public Long getIDClient() {
        return Long.valueOf(tfNume.getText());
    }
    public  String getCnpClient()
    {
        return tfNume.getText();
    }

    public void deleteClient(){

        personSercive.delete(getCnpClient());
        resetTf();

    }
    public void resetTf(){
        tfNume.setText("");

    }


}
