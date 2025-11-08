package com.bitspilani.leadmanager.Controller;

import com.bitspilani.leadmanager.Dao.CallDao;
import com.bitspilani.leadmanager.model.Call;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
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