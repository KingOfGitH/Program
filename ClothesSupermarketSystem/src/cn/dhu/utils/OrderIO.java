package cn.dhu.utils;

import cn.dhu.bean.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OrderIO {

    private static List<Order> orders=new ArrayList<>();//static作用于在本类范围内
    private static final String ORDER_FILE="order.obj";//final常量，static本类

    public void addOrder(Order order) throws BusinessException{
        orders.add(order);
        writeOrders();
    }

    /**
     * 调用了本类中的readOrders方法
     * @return 获取orders的get方法
     * @throws BusinessException
     */
    public List<Order> list() throws BusinessException{
        readOrders();
        return orders;
    }

    /**
     * 遍历orders，一一对比
     * @param orderId
     * @return
     * @throws BusinessException
     */
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

    /**
     * 将orders写入到文件里
     * @return
     */
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

    /**
     * 打开了文件,有本类全局变量orders读取到数据
     * 调用系统readObject方法
     */
    public void readOrders(){
        try {
            ObjectInputStream inputStream=new ObjectInputStream(
                    new FileInputStream(ORDER_FILE));
            orders = (List<Order>) inputStream.readObject();
            inputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
