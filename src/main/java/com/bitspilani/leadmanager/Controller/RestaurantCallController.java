package com.bitspilani.leadmanager.Controller;

import com.bitspilani.leadmanager.Dao.RestaurantCallDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/call-details")
public class RestaurantCallController {

    @Autowired
    private RestaurantCallDao restaurantCallDAO;

    // Get a restaurant by id
    @GetMapping("/{id}")
    public String getRestaurant(@PathVariable int id) {
        try {
            return restaurantCallDAO.lastCallbyRestaurantId(id).toString();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception, maybe return an error response
        }
        return null;
    }

    // Get a restaurant by id
    @GetMapping
    public String callNeededToday() {
        try {
            return restaurantCallDAO.callRequiredToday().toString();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception, maybe return an error response
        }
        return null;
    }

}
