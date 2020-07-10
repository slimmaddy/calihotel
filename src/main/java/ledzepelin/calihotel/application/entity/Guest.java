package ledzepelin.calihotel.application.entity;

public class Guest {
    private int id;
    private String fullName;
    private String sex;
    private String email;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
