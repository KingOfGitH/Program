package cn.dhu.service;

import cn.dhu.bean.Order;
import cn.dhu.utils.BusinessException;

import java.util.List;

public interface OrderService {
    public void buyProduct(Order order)throws BusinessException;
    public List<Order> list()throws BusinessException;
    public Order findOrderById(int id)throws BusinessException;
}
