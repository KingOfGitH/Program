package cn.dhu.dao;

import cn.dhu.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhbr
 * @date 2019/4/21 20:10
 */
@Repository("accountDao")
public interface IAccountDao {

    @Select("select * from account")
    public List<Account> findAll();

    @Insert("insert into account (name,money) value (#{name},#{money})")
    public void saveAccount(Account account);
}
