package cn.edu.dhu.test;

import cn.edu.dhu.beans.User;
import cn.edu.dhu.dao.UserDAO;
import cn.edu.dhu.dao.impl.UserDAOImpl;
import cn.edu.dhu.service.UserService;
import cn.edu.dhu.service.impl.UserServiceImpl;
import org.junit.Test;

import java.util.List;

public class UserDAOTest {

    @Test
    public void testLogin(){
        User loginUser=new User();
        loginUser.setUserName("zhbr");
        loginUser.setPassword("123456");
        UserDAO userDAO=new UserDAOImpl();
        User user = userDAO.login(loginUser);
        System.out.println(user);
    }
    @Test
    public void test(){
        User user=new User();
        UserService userService=new UserServiceImpl();
        List<User> list=userService.find();
        for(int i=0;i<list.size();i++)
            System.out.println(list.get(i));
    }
    @Test
    public void test0(){
        User user=new User();
        System.out.println(user);
    }
}
