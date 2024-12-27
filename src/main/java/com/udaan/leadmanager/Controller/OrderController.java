package com.udaan.leadmanager.Controller;

import com.udaan.leadmanager.Dao.OrderDao;
import com.udaan.leadmanager.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderDao orderDAO;

    // Create a new order
    @PostMapping
    public void addOrder(@RequestBody Order order) {
        try {
            orderDAO.addOrder(order);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception, maybe return an error response
        }
    }

    // Get an order by orderId
    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable int orderId) {
        try {
            return orderDAO.getOrder(orderId);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception, maybe return an error response
        }
        return null;
    }

    // Get all orders
    @GetMapping
    public List<Order> getAllOrders() {
        try {
            return orderDAO.getAllOrders();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception, maybe return an error response
        }
        return null;
    }

    // Update an order
    @PutMapping("/{orderId}")
    public void updateOrder(@PathVariable int orderId, @RequestBody Order order) {
        try {
            order.setId(orderId);
            orderDAO.updateOrder(order);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception, maybe return an error response
        }
    }

    // Delete an order
    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable int orderId) {
        try {
            orderDAO.deleteOrder(orderId);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception, maybe return an error response
        }
    }
}
