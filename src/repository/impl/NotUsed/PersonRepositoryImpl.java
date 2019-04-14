package repository.impl.NotUsed;

import model.notUsed.Person;
import repository.NotUsed.PersonRepository;
import repository.impl.JDBConnectionWrapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonRepositoryImpl implements PersonRepository {

    JDBConnectionWrapper jdbConnectionWrapper;

    public PersonRepositoryImpl(JDBConnectionWrapper jdbConnectionWrapper) {
        this.jdbConnectionWrapper = jdbConnectionWrapper;
    }

    @Override
    public Person findByName(String name) {
        Connection connection = jdbConnectionWrapper.getConnection();


        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM person WHERE name=?");
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Person person = new Person();

                person.setId(resultSet.getLong(1));
                person.setName(resultSet.getString(2));
                person.setCNP(resultSet.getString(3));
                person.setAddres(resultSet.getString(4));

                return person;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Person findByCNP(String CNP) {
        Connection connection = jdbConnectionWrapper.getConnection();


        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM person WHERE CNP=?");
            preparedStatement.setString(1, CNP);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Person person = new Person();

                person.setId(resultSet.getLong(1));
                person.setName(resultSet.getString(2));
                person.setCNP(resultSet.getString(3));
                person.setAddres(resultSet.getString(4));

                return person;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Person findById(Long id) {
        Connection connection = jdbConnectionWrapper.getConnection();


        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM person WHERE id=?");
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Person person = new Person();

                person.setId(resultSet.getLong(1));
                person.setName(resultSet.getString(2));
                person.setCNP(resultSet.getString(3));
                person.setAddres(resultSet.getString(4));

                return person;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Person> findAll() {
        Connection connection = jdbConnectionWrapper.getConnection();

        List<Person> persons = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM person");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Person person = new Person();

                person.setId(resultSet.getLong(1));
                person.setName(resultSet.getString(2));
                person.setCNP(resultSet.getString(3));
                person.setAddres(resultSet.getString(4));

                persons.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;

    }

    @Override
    public boolean deleteByCNP(String CNP) {
        Connection connection = jdbConnectionWrapper.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM person WHERE CNP= ?");
            preparedStatement.setString(1, CNP);

            int updatedRows = preparedStatement.executeUpdate();

            return updatedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteById(Long id) {

        Connection connection = jdbConnectionWrapper.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM person WHERE id= ?");
            preparedStatement.setLong(1, id);

            int updatedRows = preparedStatement.executeUpdate();

            return updatedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Person update(Person person) {

        Connection connection = jdbConnectionWrapper.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE person SET nume=?, addres=? WHERE CNP=?",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, person.getName());

            preparedStatement.setString(2, person.getAddres());
            preparedStatement.setString(3, person.getCNP());


            int changedRows = preparedStatement.executeUpdate();

            if (changedRows > 0) {
                return person;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public Person create(Person person) {
        Connection connection = jdbConnectionWrapper.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO person (nume, CNP, addres) VALUES(?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getCNP());
            preparedStatement.setString(3, person.getAddres());

            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                person.setId(resultSet.getLong(1));
                return person;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
