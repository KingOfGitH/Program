package cn.edu.dhu.dao;

import cn.edu.dhu.beans.User;

public interface UserDAO {
    /**
     * 登陆方法
     * @param loginuser
     * @return
     */
    public User login(User loginuser);
}
