package cn.edu.dhu;

import java.util.Objects;

public class User {
    private int uid;
    private String admin;
    private String password;
    private static int userNum=0;

    public User(String admin, String password) {
        this.uid = userNum++;
        this.admin = admin;
        this.password = password;
    }


    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static int getUserNum() {
        return userNum;
    }

    public int getUid() {
        return uid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(admin, user.admin) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(admin, password);
    }
}
