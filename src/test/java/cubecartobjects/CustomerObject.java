package cubecartobjects;

public class CustomerObject {
    private String title; private String firstName; private String lastName;
    private String customerNotes; private String email; private String phone;
    private String cellPhone; private String customerPassword; private String confirmPassword;
    private String addressDescription; private String companyName; private String address;
    private String city; private String zipCode;
    private String customerGroup;

    //default constructor
    public CustomerObject() {
    }

    //constructor for the General info page
    public CustomerObject(String title, String firstName, String lastName, String customerNotes, String email, String phone, String cellPhone, String customerPassword, String confirmPassword) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerNotes = customerNotes;
        this.email = email;
        this.phone = phone;
        this.cellPhone = cellPhone;
        this.customerPassword = customerPassword;
        this.confirmPassword = confirmPassword;
    }

    //constructor for general info and address page
    public CustomerObject(String title, String firstName, String lastName, String customerNotes, String email, String phone, String cellPhone, String customerPassword, String confirmPassword, String addressDescription, String companyName, String address, String city, String zipCode) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerNotes = customerNotes;
        this.email = email;
        this.phone = phone;
        this.cellPhone = cellPhone;
        this.customerPassword = customerPassword;
        this.confirmPassword = confirmPassword;
        this.addressDescription = addressDescription;
        this.companyName = companyName;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
    }

    //constructor for all the information
    public CustomerObject(String title, String firstName, String lastName, String customerNotes, String email, String phone, String cellPhone, String customerPassword, String confirmPassword, String addressDescription, String companyName, String address, String city, String zipCode, String customerGroup) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerNotes = customerNotes;
        this.email = email;
        this.phone = phone;
        this.cellPhone = cellPhone;
        this.customerPassword = customerPassword;
        this.confirmPassword = confirmPassword;
        this.addressDescription = addressDescription;
        this.companyName = companyName;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.customerGroup = customerGroup;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCustomerNotes() {
        return customerNotes;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getAddressDescription() {
        return addressDescription;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCustomerGroup() {
        return customerGroup;
    }
}

