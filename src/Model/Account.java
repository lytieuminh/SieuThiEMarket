package Model;

public abstract class Account {
    // dependenci storeFile
    protected static StoredFiles accounts = new StoredFiles("accounts.json");
    // attribute
    protected String userName;
    protected Integer password;
    protected String tel;
    protected String role;

    protected boolean loggedIn;

    // getter setter

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getPassword() {
        return password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // constructor
    public Account() {
        this.userName = null;
        this.password = null;
        this.tel = null;
        this.role = null;
        this.loggedIn = false;
    }

    public Account(String userName, Integer password, String tel, String role) {
        this.userName = userName;
        this.password = password;
        this.tel = tel;
        this.role = role;
        this.loggedIn = false;
    }

    // methods
    public boolean checkLoggedIn() {
        // kiểm tra loggin
        return loggedIn;
    }

    public void logout() {
        this.userName = null;
        this.password = null;
        this.tel = null;
        this.role = null;
        this.loggedIn = false;
    }

    // public void setAccount(String username, int password, String tel, String
    // role) {
    // this.userName = username;
    // this.password = password;
    // this.tel = tel;
    // this.role = role;
    // this.loggedIn = true;
    // }

    public static StoredFiles getAccount() {
        return accounts;
    }
}
