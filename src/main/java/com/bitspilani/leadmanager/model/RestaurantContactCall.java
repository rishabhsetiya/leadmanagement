package com.bitspilani.leadmanager.model;

public class RestaurantContactCall {
    Restaurant restaurant;
    Contact contact;
    Call call;

    public RestaurantContactCall(Restaurant restaurant, Contact contact, Call call){
        this.restaurant = restaurant;
        this.contact = contact;
        this.call=call;
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "{" +
                "\"RestaurantId\": \"" + restaurant.getId() + "\"," +
                "\"RestaurantName\": \"" + restaurant.getName() + "\"," +
                "\"lastCallTime\": \"" + call.getCallTimestamp() + "\"," +
                "\"RepresentativeName\": \"" + contact.getName() + "\"," +
                "\"RepresentativeRole\": \"" + contact.getRole() + "\"" +
                "}";
    }
}
