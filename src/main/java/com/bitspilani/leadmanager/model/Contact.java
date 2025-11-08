package com.bitspilani.leadmanager.model;

public class Contact {
    private int contactId;
    private int restaurantId;
    private String name;
    private String email;
    private String phoneNumber;
    private Role role;

    // Constructor
    public Contact(int contactId, int restaurantId, String name, String email, String phoneNumber, Role role) {
        this.contactId = contactId;
        this.restaurantId = restaurantId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    // Getter for contactId
    public int getContactId() {
        return contactId;
    }

    // Setter for contactId
    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    // Getter for restaurantId
    public int getRestaurantId() {
        return restaurantId;
    }

    // Setter for restaurantId
    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for phoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setter for phoneNumber
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Getter for role
    public Role getRole() {
        return role;
    }

    // Setter for role
    public void setRole(Role role) {
        this.role = role;
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "Contact{" +
                "contactId=" + contactId +
                ", restaurantId=" + restaurantId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
