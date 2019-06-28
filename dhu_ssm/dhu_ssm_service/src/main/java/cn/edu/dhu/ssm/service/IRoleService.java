package cn.edu.dhu.ssm.service;

import cn.edu.dhu.ssm.domain.Permission;
import cn.edu.dhu.ssm.domain.Role;

import java.util.List;

/**
 * @author zhbr
 * @date 2019/6/28 12:55
 */
public interface IRoleService {
    List<Role> findAll();

    void save(Role role);

    Role findById(String roleId);

    List<Permission> findOtherPermissions(String roleId);

    void addPermissionToRole(String roleId, String[] permissionIds);
}
