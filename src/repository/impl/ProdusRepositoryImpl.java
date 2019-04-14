package repository.impl;

import model.Product;
import repository.ProdusRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdusRepositoryImpl implements ProdusRepository {
    JDBConnectionWrapper jdbConnectionWrapper;

    public ProdusRepositoryImpl(JDBConnectionWrapper jdbConnectionWrapper) {
        this.jdbConnectionWrapper = jdbConnectionWrapper;
    }

    @Override
    public Product findByISBN(String ISBN) {


        Connection connection = jdbConnectionWrapper.getConnection();


        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM produs WHERE ISBN=?");
            preparedStatement.setString(1, ISBN);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Product product = new Product();

                product.setId(resultSet.getLong(1));
                product.setISBN(resultSet.getString(2));
                product.setGenre(resultSet.getString(3));
                product.setTitle(resultSet.getString(4));
                product.setAuthor(resultSet.getString(5));
                product.setPrice(resultSet.getInt(6));
                product.setQuantity(resultSet.getInt(7));

                return product;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product findById(Long id) {


        Connection connection = jdbConnectionWrapper.getConnection();


        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM produs WHERE id=?");
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Product product = new Product();

                product.setId(resultSet.getLong(1));
                product.setISBN(resultSet.getString(2));
                product.setGenre(resultSet.getString(3));
                product.setTitle(resultSet.getString(4));
                product.setAuthor(resultSet.getString(5));
                product.setPrice(resultSet.getInt(6));
                product.setQuantity(resultSet.getInt(7));

                return product;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> findAll() {

        Connection connection = jdbConnectionWrapper.getConnection();

        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM produs");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Product product = new Product();

                product.setId(resultSet.getLong(1));
                product.setISBN(resultSet.getString(2));
                product.setGenre(resultSet.getString(3));
                product.setTitle(resultSet.getString(4));
                product.setAuthor(resultSet.getString(5));
                product.setPrice(resultSet.getInt(6));
                product.setQuantity(resultSet.getInt(7));

                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public boolean deleteById(Long id) {
        Connection connection = jdbConnectionWrapper.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM produs WHERE id= ?");
            preparedStatement.setLong(1, id);

            int updatedRows = preparedStatement.executeUpdate();

            return updatedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Product update(Product product) {


        Connection connection = jdbConnectionWrapper.getConnection();
        try {
            //TODO to add anoter field to be edit
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE produs SET quantity=? WHERE id=?",
                    Statement.RETURN_GENERATED_KEYS);


            //TODO de mai adaugat field-uri de editat
            preparedStatement.setInt(1, product.getQuantity());
            preparedStatement.setLong(2, product.getId());

            int changedRows = preparedStatement.executeUpdate();

            if (changedRows > 0) {
                return product;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public Product create(Product product) {
        Connection connection = jdbConnectionWrapper.getConnection();
        try {
            Statement statement = connection.createStatement();


            String safe="SET FOREIGN_KEY_CHECKS=0;";
            statement.execute(safe);

            //TODO test first in MySQL workbanch
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO produs (ISBN, genre, title, author, price, quantity) VALUES(?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, product.getISBN());
            preparedStatement.setString(2, product.getGenre());
            preparedStatement.setString(3, product.getTitle());
            preparedStatement.setString(4, product.getAuthor());
            preparedStatement.setInt(5, product.getPrice());
            preparedStatement.setInt(6, product.getQuantity());


            //TODO dont work here add product in this table
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            safe="SET FOREIGN_KEY_CHECKS=1;";
            statement.execute(safe);
            if (resultSet.next()) {
                product.setId(resultSet.getLong(1));
                return product;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
