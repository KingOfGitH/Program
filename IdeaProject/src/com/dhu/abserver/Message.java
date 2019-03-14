package com.dhu.abserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 * 具体的被观察者
 */

public class Message implements MessageSubject{
//    维护的观察者列表
    private List<com.dhu.abserver.Observer> list=new ArrayList<>();

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String message) {
        this.msg = message;
        notifyObserver();
    }

    @Override
    public void registerObserver(com.dhu.abserver.Observer observer) {

        list.add((com.dhu.abserver.Observer) observer);
    }

    @Override
    public void removeObserver(com.dhu.abserver.Observer observer) {

        list.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (int i = 0; i <list.size(); i++) {
            com.dhu.abserver.Observer observer = list.get(i);
            observer.update(msg);
        }
    }
}
