package cn.edu.dhu.ssm.service.Impl;

import cn.edu.dhu.ssm.dao.IProductDao;
import cn.edu.dhu.ssm.domain.Product;
import cn.edu.dhu.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhbr
 * @date 2019/6/17 16:06
 */
@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }
}
