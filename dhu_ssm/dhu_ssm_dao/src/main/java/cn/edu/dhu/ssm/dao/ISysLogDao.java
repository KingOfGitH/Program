package cn.edu.dhu.ssm.dao;

import cn.edu.dhu.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhbr
 * @date 2019/7/8 12:30
 */
public interface ISysLogDao {

    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog);

    @Select("select * from syslog")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="visitTime",property="visitTime"),
            @Result(column="ip",property="ip"),
            @Result(column="url",property="url"),
            @Result(column="executionTime",property="executionTime"),
            @Result(column="method",property="method"),
            @Result(column="username",property="username")
    })
    List<SysLog> findAll();
}
