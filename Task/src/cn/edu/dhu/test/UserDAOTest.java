package cn.edu.dhu.test;

import cn.edu.dhu.beans.User;
import cn.edu.dhu.dao.UserDAO;
import cn.edu.dhu.dao.impl.UserDAOImpl;
import org.junit.Test;

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
}
