package cn.edu.dhu.beans;

import cn.edu.dhu.util.ChangeEncoding;

public class User {
    private int id;
    private String userName;
    private String password;
    private String gender;
    private int age;
    private String region;
    private String email;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + this.getGender() + '\'' +
                ", age=" + age +
                ", region='" + this.getRegion() + '\'' +
                ", email=" + email +
                '}';
    }
    public String toString(int i) {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender+ '\'' +
                ", age=" + age +
                ", region='" + region + '\'' +
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

    public String getGenderIso() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRegionIso() {
        return region;
    }
    public String getRegion() {
        return ChangeEncoding.ChangeEncoding(region);
    }

    public void setRegion(String region) {
        this.region = region;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
