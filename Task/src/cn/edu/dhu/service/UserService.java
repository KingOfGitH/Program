package cn.edu.dhu.service;

import cn.edu.dhu.beans.User;

import java.util.List;

/**
 * @author zhbr
 * @date 2019/4/3 17:17
 */
public interface UserService {
    public List<User> find();//查找所有数据，直接调用UserDAO中的同名方法
    public User login(User loginuser);
}
