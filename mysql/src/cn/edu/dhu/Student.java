package cn.edu.dhu;

import java.io.UnsupportedEncodingException;

public class Student {
    private int id;
    private String name;
    private String gender;

    @Override
    public String toString() {
        try {
            return "Student{" +
                    "id=" + id +
                    ", name='" + new String(name.getBytes("ISO-8859-1"),"utf8") + '\'' +
                    ", gender='" + new String(gender.getBytes("ISO-8859-1"),"utf8") + '\'' +
                    '}';
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "失败";
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
