package cn.edu.dhu.ssm.service.Impl;

import cn.edu.dhu.ssm.dao.IUserDao;
import cn.edu.dhu.ssm.domain.Role;
import cn.edu.dhu.ssm.domain.UserInfo;
import cn.edu.dhu.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhbr
 * @date 2019/6/27 18:38
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo=userDao.findByUsername(username);
        if (userInfo!=null){
            List<Role> roles = userInfo.getRoles();
            if (roles==null) {
                System.out.println("无角色信息");
                return null;
            }
            List<SimpleGrantedAuthority> authoritys = new ArrayList<>();
            for (Role role:roles){
                authoritys.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
            }
            System.out.println(authoritys.toString());
            User user=new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus()==0?false:true,
                    true,true,true,authoritys);

            return user;
        }
        System.out.println("无用户数据");
        return null;
    }

    @Override
    public List<UserInfo> findAll() {
        return userDao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userDao.save(userInfo);
    }

    @Override
    public UserInfo findById(String id) {
        return userDao.findById(id);
    }



    @Override
    public List<Role> findOtherRoles(String userId) {
        return userDao.findOtherRoles(userId);
    }

    @Override
    public void addRoleToUser(String userId, String[] roles) {
        for (String roleId:roles){
            userDao.addRoleToUser(userId,roleId);
        }
    }
}
