package repository.impl.NotUsed;

import model.notUsed.Account;
import repository.NotUsed.AccountRepository;
import repository.impl.JDBConnectionWrapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryImpl implements AccountRepository {

    JDBConnectionWrapper jdbConnectionWrapper;

    public AccountRepositoryImpl(JDBConnectionWrapper jdbConnectionWrapper) {
        this.jdbConnectionWrapper = jdbConnectionWrapper;
    }

    @Override
    public Account findByIBAN(String iban) {


        Connection connection = jdbConnectionWrapper.getConnection();


        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM account WHERE iban=?");
            preparedStatement.setString(1, iban);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Account account = new Account();

                account.setId(resultSet.getLong(1));
                account.setIban(resultSet.getString(2));
                account.setId_person(resultSet.getLong(3));
                account.setType(resultSet.getString(4));
                account.setMoney(resultSet.getInt(5));
                account.setDate_of_caretion(resultSet.getDate(6));

                return account;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Account findById(Long id) {

        Connection connection = jdbConnectionWrapper.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM account WHERE id=?");
            preparedStatement.setLong(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next())
            {
                Account account = new Account();

                account.setId(resultSet.getLong(1));
                account.setIban(resultSet.getString(2));
                account.setId_person(resultSet.getLong(3));
                account.setType(resultSet.getString(4));
                account.setMoney(resultSet.getInt(5));
                account.setDate_of_caretion(resultSet.getDate(6));

                return account;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Account> findByIdPerson(Long id_person) {
        Connection connection = jdbConnectionWrapper.getConnection();

        List<Account> accounts = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM account WHERE id_person=?");
            preparedStatement.setLong(1,id_person);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Account account = new Account();

                account.setId(resultSet.getLong(1));
                account.setIban(resultSet.getString(2));
                account.setId_person(resultSet.getLong(3));
                account.setType(resultSet.getString(4));
                account.setMoney(resultSet.getInt(5));
                account.setDate_of_caretion(resultSet.getDate(6));


                accounts.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public List<Account> findAll() {

        Connection connection = jdbConnectionWrapper.getConnection();

        List<Account> accounts = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM account");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Account account = new Account();

                account.setId(resultSet.getLong(1));
                account.setIban(resultSet.getString(2));
                account.setId_person(resultSet.getLong(3));
                account.setType(resultSet.getString(4));
                account.setMoney(resultSet.getInt(5));
                account.setDate_of_caretion(resultSet.getDate(6));


                accounts.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public boolean deleteById(Long id) {
        Connection connection = jdbConnectionWrapper.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM account WHERE id= ?");
            preparedStatement.setLong(1, id);

            int updatedRows = preparedStatement.executeUpdate();

            return updatedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Account update(Account account) {


        Connection connection = jdbConnectionWrapper.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE account SET money=? WHERE id=?",
                    Statement.RETURN_GENERATED_KEYS);


            preparedStatement.setInt(1, account.getMoney());
            preparedStatement.setLong(2, account.getId());

            int changedRows = preparedStatement.executeUpdate();

            if (changedRows > 0) {
                return account;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public Account create(Account account) {
        Connection connection = jdbConnectionWrapper.getConnection();
        try {
            Statement statement = connection.createStatement();


            String safe="SET FOREIGN_KEY_CHECKS=0;";
            statement.execute(safe);

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO account (iban, id_person, typeAc, money, date_of_creation) VALUES(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, account.getIban());
            preparedStatement.setLong(2, account.getId_person());
            preparedStatement.setString(3, account.getType());
            preparedStatement.setInt(4, account.getMoney());
            preparedStatement.setDate(5, (Date) account.getDate_of_caretion());

            //TODO dont work here add account in this table
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            safe="SET FOREIGN_KEY_CHECKS=1;";
            statement.execute(safe);
            if (resultSet.next()) {
                account.setId(resultSet.getLong(1));
                return account;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}

