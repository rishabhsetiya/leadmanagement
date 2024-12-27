package com.udaan.leadmanager.model;

import java.time.LocalDateTime;

public class Call {
    private LocalDateTime callTimestamp;
    private int contactId;
    private int restaurantId;

    // Constructor
    public Call(LocalDateTime callTimestamp, int contactId, int restaurantId) {
        this.callTimestamp = callTimestamp;
        this.contactId = contactId;
        this.restaurantId = restaurantId;
    }

    // Getter for callTimestamp
    public LocalDateTime getCallTimestamp() {
        return callTimestamp;
    }

    // Setter for callTimestamp
    public void setCallTimestamp(LocalDateTime callTimestamp) {
        this.callTimestamp = callTimestamp;
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

    // toString method for easy printing
    @Override
    public String toString() {
        return "Call{" +
                "callTimestamp=" + callTimestamp +
                ", contactId=" + contactId +
                ", restaurantId=" + restaurantId +
                '}';
    }
}
