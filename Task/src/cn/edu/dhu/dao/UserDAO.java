package cn.edu.dhu.dao;

import cn.edu.dhu.beans.User;

import java.util.List;

public interface UserDAO {
    /**
     * 登陆方法
     * @param loginuser
     * @return
     */
    public User login(User loginuser);
    public List<User> find();//查找所有数据
    public User find(String userName);//根据用户名查找
    public void insert(User registeruser);
    public void change(User changeuser);
}
