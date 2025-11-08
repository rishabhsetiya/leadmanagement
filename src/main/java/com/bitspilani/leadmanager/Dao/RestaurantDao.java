package com.bitspilani.leadmanager.Dao;

import com.bitspilani.leadmanager.model.Frequency;
import com.bitspilani.leadmanager.model.Restaurant;
import com.bitspilani.leadmanager.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RestaurantDao {
    private Connection connection;

    @Autowired
    public RestaurantDao(Connection connection) {
        this.connection = connection;
    }

    public void addRestaurant(Restaurant restaurant) throws SQLException {
        String query = "INSERT INTO restaurants (id, name, address, status, frequency) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, restaurant.getId());
            stmt.setString(2, restaurant.getName());
            stmt.setString(3, restaurant.getAddress());
            stmt.setString(4, restaurant.getStatus().toString());
            stmt.setString(5, restaurant.getFrequency().toString());
            stmt.executeUpdate();
        }
    }

    public Restaurant getRestaurant(int id) throws SQLException {
        String query = "SELECT * FROM restaurants WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Restaurant(rs.getInt("id"), rs.getString("name"), rs.getString("address"), Status.valueOf(rs.getString("status")), Frequency.valueOf(rs.getString("frequency")));
            }
        }
        return null;
    }

    public List<Restaurant> getAllRestaurants() throws SQLException {
        List<Restaurant> restaurants = new ArrayList<>();
        String query = "SELECT * FROM restaurants";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                restaurants.add(new Restaurant(rs.getInt("id"), rs.getString("name"), rs.getString("address"), Status.valueOf(rs.getString("status")), Frequency.valueOf(rs.getString("frequency"))));
            }
        }
        return restaurants;
    }

    public List<Restaurant> getWellPerformingRestaurants(int amount, int days) throws SQLException {
        List<Restaurant> restaurants = new ArrayList<>();
        String query = "SELECT * FROM restaurants where id in (select restaurant_id from orders where order_time>CURRENT_DATE()-CAST(? AS INTEGER) group by restaurant_id having sum(amount)> ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, days);
            stmt.setInt(2, amount);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                restaurants.add(new Restaurant(rs.getInt("id"), rs.getString("name"), rs.getString("address"), Status.valueOf(rs.getString("status")), Frequency.valueOf(rs.getString("frequency"))));
            }
        }
        return restaurants;
    }

    public List<Restaurant> getUnderPerformingRestaurants(int amount, int days) throws SQLException {
        List<Restaurant> restaurants = new ArrayList<>();
        String query = "SELECT * FROM restaurants where id in (select restaurant_id from orders where order_time>CURRENT_DATE()-CAST(? AS INTEGER) group by restaurant_id having sum(amount)< ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, days);
            stmt.setInt(2, amount);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                restaurants.add(new Restaurant(rs.getInt("id"), rs.getString("name"), rs.getString("address"), Status.valueOf(rs.getString("status")), Frequency.valueOf(rs.getString("frequency"))));
            }
        }
        return restaurants;
    }

    public void updateRestaurant(Restaurant restaurant) throws SQLException {
        String query = "UPDATE restaurants SET name = ?, address = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, restaurant.getName());
            stmt.setString(2, restaurant.getAddress());
            stmt.setInt(3, restaurant.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteRestaurant(int id) throws SQLException {
        String query = "DELETE FROM restaurants WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
