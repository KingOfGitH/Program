package cn.edu.dhu.ssm.dao;

import cn.edu.dhu.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhbr
 * @date 2019/6/26 21:49
 */
public interface ITravellerDao {

    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{id})")
    List<Traveller> findById(String id);
}
