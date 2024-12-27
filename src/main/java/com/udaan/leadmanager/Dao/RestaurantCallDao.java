package com.udaan.leadmanager.Dao;

import com.udaan.leadmanager.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RestaurantCallDao {

    private Connection connection;

    @Autowired
    public RestaurantCallDao(Connection connection) {
        this.connection = connection;
    }

    public RestaurantContactCall lastCallbyRestaurantId(int id) throws SQLException {
        String query = "SELECT * FROM restaurants, contacts, calls WHERE restaurants.id=calls.restaurant_id AND calls.contact_id=contacts.id AND restaurants.id = ? order by call_time desc";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Restaurant restaurant =  new Restaurant(rs.getInt("restaurants.id"), rs.getString("restaurants.name"), rs.getString("restaurants.address"), Status.valueOf(rs.getString("restaurants.status")), Frequency.valueOf(rs.getString("restaurants.frequency")));
                Call call = new Call(rs.getTimestamp("calls.call_time").toLocalDateTime(), rs.getInt("calls.restaurant_id"), rs.getInt("calls.contact_id"));
                Contact contact = new Contact(rs.getInt("contacts.id"), rs.getInt("contacts.restaurant_id"), rs.getString("contacts.name"), rs.getString("contacts.email"), rs.getString("contacts.phone"), Role.valueOf(rs.getString("contacts.role")));
                return new RestaurantContactCall(restaurant, contact, call);
            }
        }
        return null;
    }

    public List<RestaurantCall> callRequiredToday() throws SQLException {
        List<RestaurantCall> restaurantCalls = new ArrayList<>();
        String query = "SELECT * \n" +
                "FROM restaurants, " +
                "(SELECT restaurant_id, max(call_time) AS call_time from calls " +
                "group by restaurant_id having max(call_time)<CURRENT_DATE()) AS calls \n" +
                "WHERE restaurants.id=calls.restaurant_id \n" +
                "AND (frequency = 'DAILY' OR " +
                "(frequency = 'WEEKLY' AND call_time<(CURRENT_DATE()-7)) OR " +
                "(frequency = 'MONTHLY' AND call_time<(CURRENT_DATE()-30)));";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Restaurant restaurant =  new Restaurant(rs.getInt("restaurants.id"), rs.getString("restaurants.name"), rs.getString("restaurants.address"), Status.valueOf(rs.getString("restaurants.status")), Frequency.valueOf(rs.getString("restaurants.frequency")));
                Call call = new Call(rs.getTimestamp("call_time").toLocalDateTime(), rs.getInt("calls.restaurant_id"), 0);
                restaurantCalls.add(new RestaurantCall(restaurant, call));
            }
        }
        return restaurantCalls;
    }

}
