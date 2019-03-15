package cn.dhu.ui;

import cn.dhu.bean.User;
import cn.dhu.service.UserService;
import cn.dhu.service.impl.UserServiceImpl;
import cn.dhu.utils.BusinessException;

public class RegisterClass extends BaseClass{

    public void register() throws BusinessException {
        println(getString("input.username"));
        String username = input.nextLine();
        println(getString("input.password"));
        String password = input.nextLine();
        User user= new User(username,password);
        UserService userService=new UserServiceImpl();
        userService.register(user);
    }
}
