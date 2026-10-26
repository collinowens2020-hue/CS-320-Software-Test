package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    // Test adding a contact and making sure it can be found in the system
    @Test
    public void testAddContactSuccess() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        
        service.addContact(contact);
        
        assertNotNull(service.getContact("1"));
        assertEquals("John", service.getContact("1").getFirstName());
    }

    // Test that adding two contacts with the exact same ID causes an error
    @Test
    public void testAddDuplicateContactId() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("1", "Jane", "Smith", "0987654321", "456 Oak Ave");
        
        service.addContact(contact1);
        
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }

    // Test that deleting an existing contact removes it completely
    @Test
    public void testDeleteContactSuccess() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        
        service.addContact(contact);
        service.deleteContact("1");
        
        assertNull(service.getContact("1"));
    }

    // Test that attempting to delete an ID that doesn't exist throws an error
    @Test
    public void testDeleteContactNotFound() {
        ContactService service = new ContactService();
        
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("999");
        });
    }

    // Test that updating contact details alters the information successfully
    @Test
    public void testUpdateContactSuccess() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        
        service.addContact(contact);
        service.updateContact("1", "Jane", "Smith", "0987654321", "456 Oak Ave");
        
        assertEquals("Jane", service.getContact("1").getFirstName());
        assertEquals("Smith", service.getContact("1").getLastName());
        assertEquals("0987654321", service.getContact("1").getPhone());
        assertEquals("456 Oak Ave", service.getContact("1").getAddress());
    }

    // Test that attempting to update an ID that doesn't exist throws an error
    @Test
    public void testUpdateContactNotFound() {
        ContactService service = new ContactService();
        
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact("999", "Jane", "Smith", "0987654321", "456 Oak Ave");
        });
    }
}
