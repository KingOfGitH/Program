package com.dhu.abserver;

/**
 * 具体的观察者
 */

public class abserverUser implements Observer{
    private String name;

    public abserverUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name+"收到消息"+message);
    }
}
