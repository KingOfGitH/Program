package cn.dhu.test;

import cn.dhu.dao.IAccountDao;
import cn.dhu.domain.Account;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhbr
 * @date 2019/4/21 23:16
 */
@Service
public class TestService {

    private IAccountDao accountDao;

    @Autowired
    public TestService(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }


    @Test
    public void run1(){
        List<Account> all = accountDao.findAll();
        for (Account account:all){
            System.out.println(account);
        }
    }

}
