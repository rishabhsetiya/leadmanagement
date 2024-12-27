package com.udaan.leadmanager.Dao;

import com.udaan.leadmanager.model.Order;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDao {
    private Connection connection;

    public OrderDao(Connection connection) {
        this.connection = connection;
    }

    public void addOrder(Order order) throws SQLException {
        String query = "INSERT INTO orders (id, restaurant_id, order_time, amount) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, order.getId());
            stmt.setInt(2, order.getRestaurantId());
            stmt.setTimestamp(3, Timestamp.valueOf(order.getTimestamp()));
            stmt.setDouble(4, order.getAmount());
            stmt.executeUpdate();
        }
    }

    public Order getOrder(int orderId) throws SQLException {
        String query = "SELECT * FROM orders WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Order(rs.getInt("id"), rs.getInt("restaurant_id"), rs.getTimestamp("order_time").toLocalDateTime(), rs.getDouble("amount"));
            }
        }
        return null;
    }

    public List<Order> getAllOrders() throws SQLException {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM orders";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                orders.add(new Order(rs.getInt("id"),rs.getInt("restaurant_id"), rs.getTimestamp("order_time").toLocalDateTime(), rs.getDouble("amount")));
            }
        }
        return orders;
    }

    public void updateOrder(Order order) throws SQLException {
        String query = "UPDATE orders SET restaurant_id = ?, amount = ? WHERE order_time = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, order.getRestaurantId());
            stmt.setDouble(2, order.getAmount());
            stmt.setTimestamp(3, Timestamp.valueOf(order.getTimestamp()));
            stmt.executeUpdate();
        }
    }

    public void deleteOrder(int orderId) throws SQLException {
        String query = "DELETE FROM orders WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, orderId);
            stmt.executeUpdate();
        }
    }
}
