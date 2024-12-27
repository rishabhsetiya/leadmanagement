package com.udaan.leadmanager.model;

import java.time.LocalDateTime;

public class Order {
    private int id;
    private int restaurantId;
    private LocalDateTime timestamp;
    private double amount;

    // Constructor
    public Order(int orderId, int restaurantId, LocalDateTime timestamp, double amount) {
        this.id = orderId;
        this.restaurantId = restaurantId;
        this.timestamp = timestamp;
        this.amount = amount;
    }

    // Getter for orderId
    public int getId() {
        return id;
    }

    // Setter for orderId
    public void setId(int id) {
        this.id = id;
    }

    // Getter for restaurantId
    public int getRestaurantId() {
        return restaurantId;
    }

    // Setter for restaurantId
    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    // Getter for timestamp
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    // Setter for timestamp
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    // Getter for amount
    public double getAmount() {
        return amount;
    }

    // Setter for amount
    public void setAmount(double amount) {
        this.amount = amount;
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                "restaurantId=" + restaurantId +
                ", timestamp=" + timestamp +
                ", amount=" + amount +
                '}';
    }
}
