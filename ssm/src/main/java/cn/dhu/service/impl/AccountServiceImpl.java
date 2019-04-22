package cn.dhu.service.impl;

import cn.dhu.dao.IAccountDao;
import cn.dhu.domain.Account;
import cn.dhu.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhbr
 * @date 2019/4/21 20:15
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;


    @Override
    public List<Account> findAll() {
        System.out.println("cn.dhu.service.impl.AccountServiceImpl.findAll");
        System.out.println(accountDao);
        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("cn.dhu.service.impl.AccountServiceImpl.saveAccount");
        accountDao.saveAccount(account);
    }
}
