package com.udaan.leadmanager.Controller;

import com.udaan.leadmanager.Dao.RestaurantDao;
import com.udaan.leadmanager.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantDao restaurantDAO;

    // Create a new restaurant
    @PostMapping
    public void addRestaurant(@RequestBody Restaurant restaurant) {
        try {
            restaurantDAO.addRestaurant(restaurant);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception, maybe return an error response
        }
    }

    // Get a restaurant by id
    @GetMapping("/{id}")
    public Restaurant getRestaurant(@PathVariable int id) {
        try {
            return restaurantDAO.getRestaurant(id);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception, maybe return an error response
        }
        return null;
    }

    // Get all restaurants
    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        try {
            return restaurantDAO.getAllRestaurants();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception, maybe return an error response
        }
        return null;
    }

    // Get well performing restaurants
    @GetMapping("/well-performing/{amount}/{days}")
    public List<Restaurant> getWellPerformingRestaurants(@PathVariable int amount, @PathVariable int days) {
        try {
            return restaurantDAO.getWellPerformingRestaurants(amount, days);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception, maybe return an error response
        }
        return null;
    }

    // Get well performing restaurants
    @GetMapping("/under-performing/{amount}/{days}")
    public List<Restaurant> getUnderPerformingRestaurants(@PathVariable int amount, @PathVariable int days) {
        try {
            return restaurantDAO.getUnderPerformingRestaurants(amount, days);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception, maybe return an error response
        }
        return null;
    }

    // Update a restaurant
    @PutMapping("/{id}")
    public void updateRestaurant(@PathVariable int id, @RequestBody Restaurant restaurant) {
        try {
            restaurant.setId(id);
            restaurantDAO.updateRestaurant(restaurant);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception, maybe return an error response
        }
    }

    // Delete a restaurant
    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable int id) {
        try {
            restaurantDAO.deleteRestaurant(id);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception, maybe return an error response
        }
    }
}
