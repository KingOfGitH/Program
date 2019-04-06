package cn.edu.dhu.service.impl;

import cn.edu.dhu.beans.Page;
import cn.edu.dhu.beans.User;
import cn.edu.dhu.dao.UserDAO;
import cn.edu.dhu.dao.impl.UserDAOImpl;
import cn.edu.dhu.service.UserService;

import java.util.List;
import java.util.Map;

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

    @Override
    public User login(User loginuser) {
        return userDAO.login(loginuser);
    }

    @Override
    public void register(User registeruser) {
        userDAO.register(registeruser);
    }

    @Override
    public void delete(String userName) {
        userDAO.delete(userName);
    }

    @Override
    public User find(String userName) {
        return userDAO.find(userName);
    }

    @Override
    public void update(User updateuser) {
        userDAO.update(updateuser);
    }

    @Override
    public void delete(String[] userNames) {
        userDAO.delete(userNames);
    }

    @Override
    public Page<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> contion) {
        int currentPage= Integer.parseInt(_currentPage);
        int rows= Integer.parseInt(_rows);

        Page<User> page=new Page<>();
        page.setCurrentPage(currentPage);
        page.setRows(rows);

        int totalCount=userDAO.findTotalCount(contion);
        page.setTotalCount(totalCount);
        page.setList(userDAO.findCurrentPage((currentPage-1)*rows,rows,contion));
        page.setTotalPage(totalCount%rows == 0 ? totalCount/rows : totalCount/rows+1);


        return page;
    }
}
