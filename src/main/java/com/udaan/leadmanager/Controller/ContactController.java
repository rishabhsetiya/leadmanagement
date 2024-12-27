package com.udaan.leadmanager.Controller;

import com.udaan.leadmanager.Dao.ContactDao;
import com.udaan.leadmanager.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactDao contactDAO;

    // Create a new contact
    @PostMapping
    public void addContact(@RequestBody Contact contact) {
        try {
            contactDAO.addContact(contact);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception, maybe return an error response
        }
    }

    // Get a contact by contactId
    @GetMapping("/{contactId}")
    public Contact getContact(@PathVariable int contactId) {
        try {
            return contactDAO.getContact(contactId);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception, maybe return an error response
        }
        return null;
    }

    // Get all contacts
    @GetMapping
    public List<Contact> getAllContacts() {
        try {
            return contactDAO.getAllContacts();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception, maybe return an error response
        }
        return null;
    }

    // Update a contact
    @PutMapping("/{contactId}")
    public void updateContact(@PathVariable int contactId, @RequestBody Contact contact) {
        try {
            contact.setContactId(contactId);
            contactDAO.updateContact(contact);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception, maybe return an error response
        }
    }

    // Delete a contact
    @DeleteMapping("/{contactId}")
    public void deleteContact(@PathVariable int contactId) {
        try {
            contactDAO.deleteContact(contactId);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception, maybe return an error response
        }
    }
}

