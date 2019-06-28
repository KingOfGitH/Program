package cn.edu.dhu.ssm.service;

import cn.edu.dhu.ssm.domain.Role;
import cn.edu.dhu.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author zhbr
 * @date 2019/6/27 18:37
 */
public interface IUserService extends UserDetailsService {
    List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findById(String id);


    List<Role> findOtherRoles(String userId);

    void addRoleToUser(String userId, String[] roles);
}
