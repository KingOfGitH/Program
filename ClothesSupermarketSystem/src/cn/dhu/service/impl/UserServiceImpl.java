package cn.dhu.service.impl;

import cn.dhu.bean.User;
import cn.dhu.service.UserService;
import cn.dhu.utils.BusinessException;
import cn.dhu.utils.EmptyUtils;
import cn.dhu.utils.UserIO;

public class UserServiceImpl implements UserService {
    @Override
    public User register(User user) throws BusinessException {
        UserIO userIO=new UserIO();
        userIO.adduser(user);
        userIO.writeUsers();
        return user;
    }

    @Override
    public User login(User user) throws BusinessException {
        return null;
    }

    @Override
    public User login(String username, String password) throws BusinessException {

        if (EmptyUtils.isEmpty(username)){
            throw new BusinessException("username.notnull");
        }
        if (EmptyUtils.isEmpty(password)){
            throw new BusinessException("password.notnull");
        }
        UserIO userIO=new UserIO();
        return userIO.findByUsernamePassword(username,password);
    }
}
