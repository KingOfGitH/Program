package cn.dhu.ProducterCustomer;

/**两个线程协同工作，先生产再消费；
 * sleep：让线程进入休眠状态，让出CPU的时间片，不释放对象监视器的所有权（对象锁）
 * wait：让线程进入等待状态，让出CPU的时间片，释放对象监视器的所有权，等待notify唤醒**/
public class ProducterCustomer {
    public static void main(String[] args) {
        Food food=new Food();
        Producter producter=new Producter(food);
        Customer customer=new Customer(food);
        Thread t1=new Thread(producter);
        Thread t2=new Thread(customer);
        t1.start();
        t2.start();
    }
}
