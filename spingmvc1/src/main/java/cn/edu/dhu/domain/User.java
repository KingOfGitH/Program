package cn.edu.dhu.domain;

import java.io.Serializable;

/**
 * @author zhbr
 * @date 2019/4/19 20:31
 */
public class User implements Serializable {
    private String uname;
    private Integer age;
    private int date;

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", age=" + age +
                ", date=" + date +
                '}';
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
