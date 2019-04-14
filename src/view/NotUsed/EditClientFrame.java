package view.NotUsed;

import model.notUsed.Person;
import service.NotUsed.AccountService;
import service.NotUsed.PersonSercive;
import service.UserService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditClientFrame extends JFrame{
    JFrame frameMain = new JFrame("Edit Person");
    JPanel panel = new JPanel();
    JLabel label = new JLabel("CNP");
    JLabel label2 = new JLabel("Nume");
    JLabel label3 = new JLabel("Adresa");
    //JLabel label4 = new JLabel("Email");
    //JLabel label5 = new JLabel("Varsta");

    JTextField tfCNP = new JTextField();
    JTextField tfNume = new JTextField();
    JTextField tfPrenume = new JTextField();
   // JTextField tfEmail = new JTextField();
   // JTextField tfVarsta = new JTextField();



    JButton addClientBtn = new JButton("EDIT");

    UserService userService;
    PersonSercive personSercive;
    AccountService accountService;



    public EditClientFrame(UserService userService, AccountService accountService, PersonSercive personSercive) {

        this.userService=userService;
        this.accountService= accountService;
        this.personSercive = personSercive;

        frameMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameMain.setSize(280, 250);
        frameMain.setLocationRelativeTo(null);

        panel.setLayout(null);

        label.setSize(100, 20);
        label.setLocation(20, 20);

        label2.setSize(60, 20);
        label2.setLocation(20, 50);


        label3.setSize(60, 20);
        label3.setLocation(20, 80);

       /* label4.setSize(60, 20);
        label4.setLocation(20, 110);

        label5.setSize(60, 20);
        label5.setLocation(20, 140);*/


        tfCNP.setSize(120, 20);
        tfCNP.setLocation(100, 20);

        tfNume.setSize(120, 20);
        tfNume.setLocation(100, 50);

        tfPrenume.setSize(120, 20);
        tfPrenume.setLocation(100, 80);

        /*tfEmail.setSize(120, 20);
        tfEmail.setLocation(100, 110);

        tfVarsta.setSize(120, 20);
        tfVarsta.setLocation(100, 140);*/



        addClientBtn.setSize(120, 20);
        addClientBtn.setLocation(60, 170);

        addClientBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editPerson();
            }
        });

        panel.add(label);
        panel.add(label2);
        panel.add(label3);
       /* panel.add(label4);
        panel.add(label5);*/

        panel.add(addClientBtn);
        panel.add(tfCNP);
        panel.add(tfNume);
        panel.add(tfPrenume);
       /* panel.add(tfEmail);
        panel.add(tfVarsta);*/

        frameMain.setContentPane(panel);
        frameMain.setVisible(true);
    }


    public String getCnp() {
        return tfCNP.getText();
    }

    public String getNume() {
        return tfNume.getText();
    }

    public String getPrenume() {
        return tfPrenume.getText();
    }
    /*public String getEmail()
    {
        return tfEmail.getText();
    }
    public int getVarsta()
    {
        return Integer.valueOf(tfVarsta.getText());
    }*/

    public void editPerson() {


        Person person = new Person();
        person.setName(getNume());
        person.setCNP(getCnp());
        person.setAddres(getPrenume());


        //System.out.println(person.getCNP()+" "+ person.getName()+ " " + person.getAddres());

        personSercive.save(person);

        resetTf();
    }
    public void resetTf(){
        tfPrenume.setText("");
        tfNume.setText("");
        tfCNP.setText("");
       /* tfVarsta.setText("");
        tfEmail.setText("");*/
    }


}
