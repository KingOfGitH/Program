package cn.edu.dhu.service;

import cn.edu.dhu.beans.Page;
import cn.edu.dhu.beans.User;

import java.util.List;
import java.util.Map;

/**
 * @author zhbr
 * @date 2019/4/3 17:17
 */
public interface UserService {
    public List<User> find();//查找所有数据，直接调用UserDAO中的同名方法
    public User login(User loginuser);
    public void register(User registeruser);
    public void delete(String userName);
    public User find(String userName);//根据用户名查找
    public void update(User updateuser);
    public void delete(String[] userNames);

    Page<User> findUserByPage(String currentPage, String rows, Map<String, String[]> contion);
}
