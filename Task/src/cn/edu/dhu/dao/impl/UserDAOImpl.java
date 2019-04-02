package cn.edu.dhu.dao.impl;

import cn.edu.dhu.beans.User;
import cn.edu.dhu.dao.UserDAO;
import cn.edu.dhu.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDAOImpl implements UserDAO {

    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());



    @Override
    public User login(User loginuser) {
        try {
            String sql="SELECT * FROM taskUser WHERE userName=? AND password = ?";
            User user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),
                    loginuser.getUserName(), loginuser.getPassword());
            return user;
        }catch (Exception e){
            return null;
        }
    }
}
