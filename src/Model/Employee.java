package Model;

public class Employee extends Account {
    // attribute

    // constructor
    public Employee() {

    }

    public Employee(String userName, Integer password, String tel, String role) {
        super(userName, password, tel, role);
    }

    // methods
    public void setAccountEmployee(String username, int password, String tel, String role) {
        this.userName = username;
        this.password = password;
        this.tel = tel;
        this.role = role;
        this.loggedIn = true;
    }
}
