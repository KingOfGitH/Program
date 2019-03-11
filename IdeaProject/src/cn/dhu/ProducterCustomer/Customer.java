package cn.dhu.ProducterCustomer;

public class Customer implements Runnable {
    private Food food;

    public Customer(Food food) {
        this.food = food;
    }

    @Override
    public void run() {
        for (int i=0;i<20;i++){
            food.get();
        }
    }
}
