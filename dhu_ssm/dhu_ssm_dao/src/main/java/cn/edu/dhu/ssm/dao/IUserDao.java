package cn.edu.dhu.ssm.dao;

import cn.edu.dhu.ssm.domain.Role;
import cn.edu.dhu.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zhbr
 * @date 2019/6/27 18:40
 */
public interface IUserDao {
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,
                    many = @Many(select = "cn.edu.dhu.ssm.dao.IRoleDao.findByUserId")),
    })
    UserInfo findByUsername(String username);

    @Select("select * from users")
    List<UserInfo> findAll();

    @Insert("insert into users(email,username,password,phoneNum,status)   "  +
            "  values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo);

    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,
                    many = @Many(select = "cn.edu.dhu.ssm.dao.IRoleDao.findByUserId")),
    })
    UserInfo findById(String id);

    @Select("select * from users where id in(select userId from users_role where roleId=#{roleId})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
    })
    List<UserInfo> findByRoleId(String roleId);


    @Select("select * from role where id not in (select roleId from users_role where userId=#{userId})")
    List<Role> findOtherRoles(String userId);

    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId,@Param("roleId") String roleId);
}
