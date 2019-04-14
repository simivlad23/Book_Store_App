package repository.impl;

import model.Order;
import repository.OrderReository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrderReository {



    JDBConnectionWrapper jdbConnectionWrapper;

    public OrderRepositoryImpl(JDBConnectionWrapper jdbConnectionWrapper) {
        this.jdbConnectionWrapper = jdbConnectionWrapper;
    }

    @Override
    public Order findById(Long id) {
        Connection connection = jdbConnectionWrapper.getConnection();


        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM comanda WHERE id=?");
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Order order = new Order();

                order.setId(resultSet.getLong(1));
                order.setIdProd(resultSet.getLong(2));
                order.setCantitate(resultSet.getInt(3));
                return order;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Order> findAll() {
        Connection connection = jdbConnectionWrapper.getConnection();

        List<Order> orders = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM comanda");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Order order = new Order();

                order.setId(resultSet.getLong(1));
                order.setIdProd(resultSet.getLong(2));
                order.setCantitate(resultSet.getInt(3));

                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public boolean deleteById(Long id) {
        Connection connection = jdbConnectionWrapper.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM comanda WHERE id= ?");
            preparedStatement.setLong(1, id);

            int updatedRows = preparedStatement.executeUpdate();

            return updatedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Order update(Order order) {
        Connection connection = jdbConnectionWrapper.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE comanda SET cantitate=? WHERE id=?",
                    Statement.RETURN_GENERATED_KEYS);


            preparedStatement.setInt(1, order.getCantitate());
            preparedStatement.setLong(2, order.getId());

            int changedRows = preparedStatement.executeUpdate();

            if (changedRows > 0) {
                return order;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Order create(Order order) {
        Connection connection = jdbConnectionWrapper.getConnection();
        try {
            Statement statement = connection.createStatement();


            String safe="SET FOREIGN_KEY_CHECKS=0;";
            statement.execute(safe);

            //TODO test first in MySQL workbanch
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO comanda (idProdus, cantitate) VALUES(?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, order.getIdProd());
            preparedStatement.setInt(2, order.getCantitate());



            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            safe="SET FOREIGN_KEY_CHECKS=1;";
            statement.execute(safe);
            if (resultSet.next()) {
                order.setId(resultSet.getLong(1));
                return order;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
