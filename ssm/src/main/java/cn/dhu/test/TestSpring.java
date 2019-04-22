package cn.dhu.test;

import cn.dhu.dao.IAccountDao;
import cn.dhu.domain.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author zhbr
 * @date 2019/4/21 21:35
 */
public class TestSpring {

    @Test
    public void run1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        IAccountDao accountDao = (IAccountDao) context.getBean("accountDao");
        List<Account> all = accountDao.findAll();
        for (Account account:all){
            System.out.println(account);
        }
    }
}
