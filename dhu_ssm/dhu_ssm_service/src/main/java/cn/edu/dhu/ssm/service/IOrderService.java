package cn.edu.dhu.ssm.service;

import cn.edu.dhu.ssm.domain.Orders;

import java.util.List;

/**
 * @author zhbr
 * @date 2019/6/26 19:00
 */


public interface IOrderService {
    List<Orders> findAll(Integer page, Integer size);

    Orders findById(String id);
}
