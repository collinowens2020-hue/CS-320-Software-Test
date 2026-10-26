package contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    
    // In-memory storage for contacts 
    private final Map<String, Contact> contacts = new HashMap<>();
    
    // Adds a new contact if the ID is unique
    public void addContact(Contact contact) {
        // Enforce that contact object exists and ID is not a duplicate
        if (contact == null || contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Invalid or duplicate contact");
        }
        contacts.put(contact.getContactId(), contact);
    }
    
    // Removes a contact from the storage map using the ID
    public void deleteContact(String contactId) {
        // Look up the ID to make sure it exists before trying to delete
        if (contactId == null || !contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        contacts.remove(contactId);
    }
    
    // Updates contact information fields based on the provided ID
    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        // Retrieve the contact object by its unique ID key
        Contact contact = contacts.get(contactId);
        
        // Throw an exception if no contact matches that ID
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }
        
        // Apply the new values 
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhone(phone);
        contact.setAddress(address);
    }
    
    // Helper method to look up a contact by ID for verification
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}
