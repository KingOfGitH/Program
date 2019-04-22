package cn.dhu.domain;

import java.io.Serializable;

/**
 * @author zhbr
 * @date 2019/4/21 20:07
 * 账户
 */
public class Account implements Serializable {
    private Integer id;
    private String name;
    private Double money;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }

    public Account(String name, Double money) {
        this.name = name;
        this.money = money;
    }

    public Account() {
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
