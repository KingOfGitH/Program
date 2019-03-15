package cn.dhu.ui;

import cn.dhu.bean.User;
import cn.dhu.service.UserService;
import cn.dhu.service.impl.UserServiceImpl;
import cn.dhu.utils.BusinessException;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BEncoderStream;

public class LoginClass extends BaseClass{

    public void login() throws BusinessException {
        println(getString("input.username"));
        String username = input.nextLine();
        println(getString("input.password"));
        String password = input.nextLine();
//        User user= new User(username,password);
        UserService userService=new UserServiceImpl();
        User user=userService.login(username,password);

        if (user!=null){
            currUser=user;
        }else {
            throw new BusinessException("login.error");
        }
    }
}
