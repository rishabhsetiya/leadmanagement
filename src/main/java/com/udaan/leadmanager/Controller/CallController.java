package com.udaan.leadmanager.Controller;

import com.udaan.leadmanager.Dao.CallDao;
import com.udaan.leadmanager.model.Call;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/calls")
public class CallController {

    @Autowired
    private CallDao callDAO;

    // Create a new call
    @PostMapping
    public void addCall(@RequestBody Call call) {
        try {
            callDAO.addCall(call);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception, maybe return an error response
        }
    }

    // Get all calls
    @GetMapping
    public List<Call> getAllCalls() {
        try {
            return callDAO.getAllCalls();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception, maybe return an error response
        }
        return null;
    }


}