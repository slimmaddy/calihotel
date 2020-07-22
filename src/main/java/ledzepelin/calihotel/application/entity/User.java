package ledzepelin.calihotel.application.entity;

public class User {
    private int id;
    private String fullName;
    private String userName;
    private String encrypted_password;
    private String password;
    private String email;
    private int permission;
    private String salt;

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEncryptedPassword() {
        return encrypted_password;
    }

    public void setPassword(String password) { this.password = password; }

    public String getPassword() { return password; }

    public String getUserName() {
        return userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEncryptedPassword(String password) {
        this.encrypted_password = password;
    }

    public void setUserName(String userName) { this.userName = userName; }

    public void setId(int id) { this.id = id; }

    public int getPermission() { return permission; }

    public void setPermission(int permission) { this.permission = permission; }

    public String getSalt() { return salt; }

    public void setSalt(String salt) { this.salt = salt; }

    public int getId() { return id; }
}
