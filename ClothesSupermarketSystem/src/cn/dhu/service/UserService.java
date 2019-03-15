package cn.dhu.service;

import cn.dhu.bean.User;
import cn.dhu.utils.BusinessException;

public interface UserService {
    public User register(User user) throws BusinessException;
    public User login(User user) throws BusinessException;
    public User login(String username,String password) throws BusinessException;
}
