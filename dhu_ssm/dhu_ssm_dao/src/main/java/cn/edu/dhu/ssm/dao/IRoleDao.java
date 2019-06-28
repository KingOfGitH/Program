package cn.edu.dhu.ssm.dao;

import cn.edu.dhu.ssm.domain.Permission;
import cn.edu.dhu.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zhbr
 * @date 2019/6/27 19:24
 */
public interface IRoleDao {

    @Select("select * from role where id in (select roleId from users_role where userId=#{id})")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "cn.edu.dhu.ssm.dao.IPermissionDao.findByRoleId")),
    })
    List<Role> findByUserId(String id);

    @Select("select * from role")
//    @Results({
//            @Result(id=true,property = "id",column = "id"),
//            @Result(property = "roleName",column = "roleName"),
//            @Result(property = "roleDesc",column = "roleDesc"),
//            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "cn.edu.dhu.ssm.dao.IPermissionDao.findByRoleId")),
//            @Result(property = "users",column = "id",javaType = java.util.List.class,many = @Many(select = "cn.edu.dhu.ssm.dao.IUserDao.findByRoleId")),
//    })
    List<Role> findAll();

    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);

    @Select("select * from role where id=#{roleId}")
    Role findById(String roleId);

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findOtherPermissions(String roleId);

    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId,@Param("permissionId") String permissionId);
}
