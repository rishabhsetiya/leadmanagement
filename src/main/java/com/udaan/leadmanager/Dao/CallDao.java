package com.udaan.leadmanager.Dao;

import com.udaan.leadmanager.model.Call;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CallDao {
    private Connection connection;

    public CallDao(Connection connection) {
        this.connection = connection;
    }

    public void addCall(Call call) throws SQLException {
        String query = "INSERT INTO calls (call_time, contact_id, restaurant_id) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setTimestamp(1, Timestamp.valueOf(call.getCallTimestamp()));
            stmt.setInt(2, call.getContactId());
            stmt.setInt(3, call.getRestaurantId());
            stmt.executeUpdate();
        }
    }

    public List<Call> getAllCalls() throws SQLException {
        List<Call> calls = new ArrayList<>();
        String query = "SELECT * FROM calls";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                calls.add(new Call(rs.getTimestamp("call_time").toLocalDateTime(), rs.getInt("contact_id"), rs.getInt("restaurant_id")));
            }
        }
        return calls;
    }
}
