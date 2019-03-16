package cn.dhu.utils;

import cn.dhu.bean.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OrderIO {

    private static List<Order> orders=new ArrayList<>();
    private static final String ORDER_FILE="order.obj";

    public void addOrder(Order order) throws BusinessException{
        orders.add(order);
    }
    public List<Order> list() throws BusinessException{

        return orders;
    }

    public Order findByOrderId(int orderId) throws BusinessException{
        Order order;
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderId()==orderId) {
                order=orders.get(i);
                return order;
            }
        }
        return null;
    }

    public Boolean writeOrders(){
        try {
            ObjectOutputStream outputStream=new ObjectOutputStream(
                    new FileOutputStream(ORDER_FILE));
            outputStream.writeObject(orders);
            outputStream.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    public void readOrders(){
        try {
            ObjectInputStream inputStream=new ObjectInputStream(
                    new FileInputStream(ORDER_FILE));
            orders = (List<Order>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
