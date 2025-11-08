package com.bitspilani.leadmanager.Controller;

import com.bitspilani.leadmanager.Dao.ContactDao;
import com.bitspilani.leadmanager.model.Contact;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class McpTools {

    @Autowired
    private ContactDao contactDAO;

    @Tool
    public Contact getEmployee(int contactId) {
        try {
            return contactDAO.getContact(contactId);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception, maybe return an error response
        }
        return null;
    }
}
