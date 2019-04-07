package cn.edu.dhu.dao.impl;

import cn.edu.dhu.beans.User;
import cn.edu.dhu.dao.UserDAO;
import cn.edu.dhu.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDAOImpl implements UserDAO {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User login(User loginuser) {
        try {
            String sql = "SELECT * FROM taskUser WHERE userName=? AND password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                    loginuser.getUserName(), loginuser.getPassword());
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<User> find() {
        try {
            String sql = "SELECT * FROM taskUser";
            List<User> list = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
            return list;
        } catch (Exception e) {
            System.out.println("UserDAOImpl.find()");
            return null;
        }
    }

    @Override
    public User find(String userName) {
        try {
            String sql = "SELECT * FROM taskUser WHERE userName=?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), userName);
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void update(User updateuser) {
        System.out.println(updateuser.toString(1));
        String sql = "UPDATE taskuser SET gender=?,email=?,age=?,region=? WHERE userName=?";
        int update = template.update(sql, updateuser.getGenderIso(), updateuser.getEmail(), updateuser.getAge(),
                updateuser.getRegionIso(), updateuser.getUserName());
        System.out.println(update);
    }

    @Override
    public void register(User registeruser) {
        String sql = "INSERT INTO taskuser (userName,PASSWORD,gender,email,age,region) VALUE(?,?,?,?,?,?)";
        template.update(sql, registeruser.getUserName(), registeruser.getPassword(), registeruser.getGenderIso(),
                registeruser.getEmail(), registeruser.getAge(), registeruser.getRegionIso());
    }

    @Override
    public void delete(String userName) {
        String sql = "DELETE FROM taskuser WHERE userName=?";
        template.update(sql, userName);
    }

    @Override
    public void delete(String[] userNames) {
        if (null == userNames||userNames.length<=0) return;
        for (String userName:userNames){
            this.delete(userName);
        }
    }

    /**
     * 分页功能
     * @return
     * @param contion
     */
    @Override
    public int findTotalCount(Map<String, String[]> contion) {
        String sql="SELECT COUNT(*) FROM taskuser WHERE 1=1  ";
        StringBuilder stringBuilder=new StringBuilder(sql);

        Set<String> keySet = contion.keySet();

        List<Object> list = new ArrayList<>();
        for (String key:keySet){
            if ("currentPage".equals(key)||"rows".equals(key)){
                continue;
            }
            String s = contion.get(key)[0];
            if (s!=null&& ""!=s){
                stringBuilder.append(" and  "+key+"  like  ? ");
                list.add("%"+s+"%");
            }
        }

        sql=stringBuilder.toString();
        int count = template.queryForObject(sql, Integer.class , list.toArray());
        return count;
    }

    @Override
    public List<User> findCurrentPage(int start, int rows, Map<String, String[]> contion) {
        String sql="SELECT * FROM taskuser where 1=1";
        StringBuilder stringBuilder=new StringBuilder(sql);

        Set<String> keySet = contion.keySet();

        List<Object> list = new ArrayList<>();
        for (String key:keySet){
            if ("currentPage".equals(key)||"rows".equals(key)){
                continue;
            }
            String s = contion.get(key)[0];
            if (s!=null&& ""!=s){
                stringBuilder.append(" and  "+key+"  like  ? ");
                list.add("%"+s+"%");
            }
        }

        stringBuilder.append(" LIMIT ?,?");
        list.add(start);
        list.add(rows);

        sql=stringBuilder.toString();
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class), list.toArray());
        return users;
    }
}
