package cn.edu.dhu.ssm.service.Impl;

import cn.edu.dhu.ssm.dao.IOrdersDao;
import cn.edu.dhu.ssm.domain.Orders;
import cn.edu.dhu.ssm.service.IOrderService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhbr
 * @date 2019/6/26 19:01
 */

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrdersDao orderDao;

    @Override
    public List<Orders> findAll(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        return orderDao.findAll();
    }

    @Override
    public Orders findById(String id) {
        return orderDao.findById(id);
    }
}
