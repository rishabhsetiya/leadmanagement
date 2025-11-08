package com.bitspilani.leadmanager.model;

public class Restaurant {
    private int id;
    private String name;
    private String address;
    private Status status;
    private Frequency frequency;

    // Constructor
    public Restaurant(int id, String name, String address, Status status, Frequency frequency) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.status = status;
        this.frequency = frequency;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for address
    public String getAddress() {
        return address;
    }

    // Setter for address
    public void setAddress(String address) {
        this.address = address;
    }

    // Getter for status
    public Status getStatus() {
        return status;
    }

    // Setter for status
    public void setStatus(Status status) {
        this.status = status;
    }

    // Getter for frequency
    public Frequency getFrequency() {
        return frequency;
    }

    // Setter for frequency
    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
