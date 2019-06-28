package cn.edu.dhu.ssm.service;

import cn.edu.dhu.ssm.domain.Product;

import java.util.List;

/**
 * @author zhbr
 * @date 2019/6/17 16:04
 */
public interface IProductService {
    List<Product> findAll() throws Exception;

    void save(Product product) throws Exception;
}
