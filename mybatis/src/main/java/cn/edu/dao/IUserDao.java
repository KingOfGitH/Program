package cn.edu.dao;

import cn.edu.domain.User;

import java.util.List;

/**
 * @author zhbr
 * @date 2019/4/16 18:14
 */
public interface IUserDao {
//    @Select("select * from user")
    List<User> findAll();
}
