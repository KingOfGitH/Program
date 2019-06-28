package cn.edu.dhu.ssm.dao;

import cn.edu.dhu.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhbr
 * @date 2019/6/17 15:53
 */
public interface IProductDao {
    @Select("SELECT * FROM product")
    List<Product> findAll() throws Exception;

    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);


    @Select("select * from product where id=#{id}")
    Product findById(String id);
}
