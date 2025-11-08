package com.bitspilani.leadmanager.model;

public class RestaurantCall {
    Restaurant restaurant;
    Call call;

    public RestaurantCall(Restaurant restaurant, Call call){
        this.restaurant = restaurant;
        this.call=call;
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "{" +
                "\"RestaurantId\": \"" + restaurant.getId() + "\"," +
                "\"RestaurantName\": \"" + restaurant.getName() + "\"," +
                "\"lastCallTime\": \"" + call.getCallTimestamp() + "\"," +
                "\"Frequency\": \"" + restaurant.getFrequency() + "\"" +
                "}";
    }
}
