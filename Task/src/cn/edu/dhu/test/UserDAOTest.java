package cn.edu.dhu.test;

import cn.edu.dhu.beans.User;
import cn.edu.dhu.dao.UserDAO;
import cn.edu.dhu.dao.impl.UserDAOImpl;
import cn.edu.dhu.service.UserService;
import cn.edu.dhu.service.impl.UserServiceImpl;
import cn.edu.dhu.util.JDBCUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class UserDAOTest {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
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
    public void test0() throws InvocationTargetException, IllegalAccessException {
        User user=new User();
        Map<String,String[]> map = new HashMap<String, String[]>();
        String[] strings = {"1234"};
        String[] string2 = {"5678"};
        String[] string = {""};
        map.put("userName",strings);
        map.put("password1",strings);
        map.put("gender",string);
        map.put("age", strings);
        map.put("password", string2);
        map.put("email",strings);
        map.put("address",null);
        map.put("abcd",strings);
        BeanUtils.populate(user,map);
        System.out.println(user);
    }
    public void test1() throws InvocationTargetException, IllegalAccessException {
        User user=new User();
        String sql="SELECT COUNT(*) FROM taskuser WHERE 1=1  ";
        StringBuilder stringBuilder=new StringBuilder(sql);



        List<Object> list = new ArrayList<>();

                stringBuilder.append(" and  "+"userName"+"  like  ? ");
                list.add("%"+"aaa"+"% ");


        sql=stringBuilder.toString();
        int count = template.queryForObject(sql, Integer.class , list.toArray());
        System.out.println(user);
    }
    @Test
    public void test2() throws InvocationTargetException, IllegalAccessException {
        User user=new User();
        UserService userService=new UserServiceImpl();
        user=userService.find("zhbr");
        System.out.println(user);
    }
}
