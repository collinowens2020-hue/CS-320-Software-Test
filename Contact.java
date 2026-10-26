package contact;
public class Contact {
	    
	    // Class variables to hold contact details
	    private final String contactId;
	    private String firstName;
	    private String lastName;
	    private String phone;
	    private String address;
	    
	    // Constructor to initialize and validate a new contact
	    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
	        
	        // ID validation: cannot be null or over 10 characters
	        if (contactId == null || contactId.length() > 10) {
	            throw new IllegalArgumentException("Invalid contact ID");
	        }
	        
	        // First name validation: cannot be null or over 10 characters
	        if (firstName == null || firstName.length() > 10) {
	            throw new IllegalArgumentException("Invalid first name");
	        }
	        
	        // Last name validation: cannot be null or over 10 characters
	        if (lastName == null || lastName.length() > 10) {
	            throw new IllegalArgumentException("Invalid last name");
	        }
	        
	        // Phone number validation: must be exactly 10 digits and not null
	        if (phone == null || phone.length() != 10) {
	            throw new IllegalArgumentException("Invalid phone number");
	        }
	        
	        // Address validation: cannot be null or over 30 characters
	        if (address == null || address.length() > 30) {
	            throw new IllegalArgumentException("Invalid address");
	        }
	        
	        // Assigning parameters to variables if validations pass
	        this.contactId = contactId;
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.phone = phone;
	        this.address = address;
	    }
	    
	    // Getters for retrieving contact information
	    public String getContactId() { 
	        return contactId; 
	    }
	    
	    public String getFirstName() { 
	        return firstName; 
	    }
	    
	    public String getLastName() { 
	        return lastName; 
	    }
	    
	    public String getPhone() { 
	        return phone; 
	    }
	    
	    public String getAddress() { 
	        return address; 
	    }
	    
	    // Setters to update fields with required validation checks
	    public void setFirstName(String firstName) {
	        if (firstName == null || firstName.length() > 10) {
	            throw new IllegalArgumentException("Invalid first name");
	        }
	        this.firstName = firstName;
	    }
	    
	    public void setLastName(String lastName) {
	        if (lastName == null || lastName.length() > 10) {
	            throw new IllegalArgumentException("Invalid last name");
	        }
	        this.lastName = lastName;
	    }
	    
	    public void setPhone(String phone) {
	        if (phone == null || phone.length() != 10) {
	            throw new IllegalArgumentException("Invalid phone number");
	        }
	        this.phone = phone;
	    }
	    
	    public void setAddress(String address) {
	        if (address == null || address.length() > 30) {
	            throw new IllegalArgumentException("Invalid address");
	        }
	        this.address = address;
	    }
	}

