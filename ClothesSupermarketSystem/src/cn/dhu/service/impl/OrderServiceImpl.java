package cn.dhu.service.impl;

import cn.dhu.bean.Order;
import cn.dhu.service.OrderService;
import cn.dhu.utils.BusinessException;
import cn.dhu.utils.ClothesIO;
import cn.dhu.utils.OrderIO;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderIO orderIO=new OrderIO();
    @Override
    public void buyProduct(Order order) throws BusinessException {
        orderIO.addOrder(order);
    }

    @Override
    public List<Order> list() throws BusinessException {
        return orderIO.list();
    }

    @Override
    public Order findOrderById(int id) throws BusinessException {
        return orderIO.findByOrderId(id);
    }
}
