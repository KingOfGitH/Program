package cn.edu.dhu.dao;

import cn.edu.dhu.beans.User;

import java.util.List;
import java.util.Map;

public interface UserDAO {
    /**
     * 登陆方法
     * @param loginuser
     * @return
     */
    public User login(User loginuser);
    public List<User> find();//查找所有数据
    public User find(String userName);//根据用户名查找
    public void update(User updateuser);
    public void register(User registeruser);
    public void delete(String userName);
    public void delete(String[] userNames);

    //分页功能
    public int findTotalCount(Map<String, String[]> contion);

    List<User> findCurrentPage(int start, int rows, Map<String, String[]> contion);
}
