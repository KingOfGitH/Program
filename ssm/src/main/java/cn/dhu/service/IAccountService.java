package cn.dhu.service;

import cn.dhu.domain.Account;

import java.util.List;

/**
 * @author zhbr
 * @date 2019/4/21 20:12
 */
public interface IAccountService {
    public List<Account> findAll();

    public void saveAccount(Account account);
}
