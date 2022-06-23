package Model;

public class Customer extends Account {
    // attributes
    private String address;

    // getter setter
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // constructor
    public Customer() {
        super();
        this.address = null;
    }

    public Customer(String userName, Integer password, String tel, String role, String address) {
        super(userName, password, tel, role);
        this.address = address;
    }
    // methods

    @Override
    public void logout() {
        super.logout();
        this.address = null;
    }

    public void setAccountCustomer(String userName, Integer password, String tel, String role, String address) {
        this.userName = userName;
        this.password = password;
        this.tel = tel;
        this.role = role;
        this.address = address;
        this.loggedIn = true;
    }
}
