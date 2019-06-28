package cn.edu.dhu.ssm.service.Impl;

import cn.edu.dhu.ssm.dao.IPermissionDao;
import cn.edu.dhu.ssm.domain.Permission;
import cn.edu.dhu.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhbr
 * @date 2019/6/28 17:20
 */
@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);
    }
}
