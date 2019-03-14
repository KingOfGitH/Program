package com.dhu.abserver;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Observable;

import static org.junit.Assert.*;


public class ObserverTest {

    @Test
    public void observerTest(){

        Message message=new Message();
        Observer u1=new abserverUser("u1");
        Observer u2=new abserverUser("u2");
        Observer u3=new abserverUser("u3");
        message.registerObserver(u1);
        message.registerObserver(u2);
        message.registerObserver(u3);

        message.setMsg("么么哒");

        message.removeObserver(u1);

        message.setMsg("少了1个");
    }

}
