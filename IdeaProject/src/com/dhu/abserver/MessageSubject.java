package com.dhu.abserver;

import java.util.Observer;

/**
 * 被观察者接口
 */

public interface MessageSubject {
//    注册观察者
    public void registerObserver(com.dhu.abserver.Observer observer);
//    移除观察者
    public void removeObserver(com.dhu.abserver.Observer observer);
//    通知所有观察者
    public void notifyObserver();

}
