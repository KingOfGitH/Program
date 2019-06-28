package cn.edu.dhu.ssm.dao;

import cn.edu.dhu.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @author zhbr
 * @date 2019/6/26 21:32
 */
public interface IMemberDao {

    @Select("select * from member where id=#{id}")
    Member findById(String id);
}
