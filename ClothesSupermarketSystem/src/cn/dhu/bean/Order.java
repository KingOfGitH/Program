package cn.dhu.bean;

import cn.dhu.utils.OrderStatusType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单
 */

public class Order implements Serializable {
    private int orderId;
    private List<OrderItem> orderItemList=new ArrayList<>();
    private String createData;
    private float sum;
    private OrderStatusType statusType = OrderStatusType.UNPAID;//状态
    private int userId;

    public Order() {
    }

    public Order(int orderId, List<OrderItem> orderItemList, String createData, float sum, OrderStatusType statusType, int userId) {
        this.orderId = orderId;
        this.orderItemList = orderItemList;
        this.createData = createData;
        this.sum = sum;
        this.statusType = statusType;
        this.userId = userId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public String getCreateData() {
        return createData;
    }

    public void setCreateData(String createData) {
        this.createData = createData;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public OrderStatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(OrderStatusType statusType) {
        this.statusType = statusType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
