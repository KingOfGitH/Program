package cn.edu.dhu.ssm.service;

import cn.edu.dhu.ssm.domain.Permission;

import java.util.List;

/**
 * @author zhbr
 * @date 2019/6/28 17:20
 */
public interface IPermissionService {

    List<Permission> findAll();

    void save(Permission permission);
}
