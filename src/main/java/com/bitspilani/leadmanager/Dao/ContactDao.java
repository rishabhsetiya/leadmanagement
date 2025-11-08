package com.bitspilani.leadmanager.Dao;

import com.bitspilani.leadmanager.model.Contact;
import com.bitspilani.leadmanager.model.Role;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ContactDao {
    private Connection connection;

    public ContactDao(Connection connection) {
        this.connection = connection;
    }

    public void addContact(Contact contact) throws SQLException {
        String query = "INSERT INTO contacts (id, restaurant_id, name, email, phone, role) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, contact.getContactId());
            stmt.setInt(2, contact.getRestaurantId());
            stmt.setString(3, contact.getName());
            stmt.setString(4, contact.getEmail());
            stmt.setString(5, contact.getPhoneNumber());
            stmt.setString(6, contact.getRole().toString());
            stmt.executeUpdate();
        }
    }

    public Contact getContact(int contactId) throws SQLException {
        String query = "SELECT * FROM contacts WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, contactId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Contact(rs.getInt("id"), rs.getInt("restaurant_id"), rs.getString("name"), rs.getString("email"), rs.getString("phone"), Role.valueOf(rs.getString("role")));
            }
        }
        return null;
    }

    public List<Contact> getAllContacts() throws SQLException {
        List<Contact> contacts = new ArrayList<>();
        String query = "SELECT * FROM contacts";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                contacts.add(new Contact(rs.getInt("id"), rs.getInt("restaurant_id"), rs.getString("name"), rs.getString("email"), rs.getString("phone"), Role.valueOf(rs.getString("role"))));
            }
        }
        return contacts;
    }

    public void updateContact(Contact contact) throws SQLException {
        String query = "UPDATE contacts SET restaurant_id = ?, name = ?, email = ?, phone = ?, role = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, contact.getRestaurantId());
            stmt.setString(2, contact.getName());
            stmt.setString(3, contact.getEmail());
            stmt.setString(4, contact.getPhoneNumber());
            stmt.setString(5, contact.getRole().toString());
            stmt.setInt(6, contact.getContactId());
            stmt.executeUpdate();
        }
    }

    public void deleteContact(int contactId) throws SQLException {
        String query = "DELETE FROM contacts WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, contactId);
            stmt.executeUpdate();
        }
    }
}
