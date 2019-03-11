package cn.dhu.ProducterCustomer;

/**生产者**/
public class Producter implements Runnable{
    private Food food;

    public Producter(Food food) {
        this.food = food;
    }

    @Override
    public void run() {
        for (int i=0;i<20;i++){
            if (i%2==0){
                food.set("羊肉胡卜","麻辣味");
            }else {
                food.set("麻辣串","蒜蓉味");
            }
        }
    }
}
