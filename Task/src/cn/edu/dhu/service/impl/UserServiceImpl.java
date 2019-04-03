package cn.edu.dhu.service.impl;

import cn.edu.dhu.beans.User;
import cn.edu.dhu.dao.UserDAO;
import cn.edu.dhu.dao.impl.UserDAOImpl;
import cn.edu.dhu.service.UserService;

import java.util.List;

/**
 * @author zhbr
 * @date 2019/4/3 17:18
 */
public class UserServiceImpl implements UserService {
    private UserDAO userDAO=new UserDAOImpl();

    @Override
    public List<User> find() {
        return userDAO.find();
    }
}
