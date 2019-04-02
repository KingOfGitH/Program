package cn.edu.dhu.beans;

import cn.edu.dhu.util.ChangeEncoding;

import java.util.Date;

public class User {
    private int id;
    private String userName;
    private String password;
    private String gender;
    private Date birthday;
    private int age;
    private String region;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + ChangeEncoding.ChangeEncoding(gender) + '\'' +
                ", birthday=" + birthday +
                ", age=" + age +
                ", region='" + ChangeEncoding.ChangeEncoding(region)+ '\'' +
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRegion() {
        return ChangeEncoding.ChangeEncoding(region);
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
