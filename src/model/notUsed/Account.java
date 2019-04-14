package model.notUsed;

import model.EntityObject;

import java.util.Date;

public class Account extends EntityObject {

    private String iban;
    private Long id_person;
    private String type;
    private int money;
    private Date date_of_caretion;

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Long getId_person() {
        return id_person;
    }

    public void setId_person(Long id_person) {
        this.id_person = id_person;
    }

    public Date getDate_of_caretion() {
        return date_of_caretion;
    }

    public void setDate_of_caretion(Date date_of_caretion) {
        this.date_of_caretion = date_of_caretion;
    }


    @Override
    public String toString() {
        return "Account{" +
                "Iban='" + iban + '\'' +
                ", Type='" + type + '\'' +
                ", amount=" + money +
                ", Date of creation=" + date_of_caretion +
                '}';
    }
}
