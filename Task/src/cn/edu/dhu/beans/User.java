package cn.edu.dhu.beans;

import cn.edu.dhu.util.ChangeEncoding;

public class User {
    private int id;
    private String userName;
    private String password;
    private String gender;
    private int age;
    private String address;
    private String  email;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + ChangeEncoding.ChangeEncoding(gender) + '\'' +
                ", age=" + age +
                ", address='" + ChangeEncoding.ChangeEncoding(address)+ '\'' +
                ", email=" + email +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return ChangeEncoding.ChangeEncoding(gender);
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getaddress() {
        return ChangeEncoding.ChangeEncoding(address);
    }

    public void setaddress(String address) {
        this.address = address;
    }
}
