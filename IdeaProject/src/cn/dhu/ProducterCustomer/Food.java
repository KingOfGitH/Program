package cn.dhu.ProducterCustomer;

public class Food {
    private String name;
    private String desc;
    boolean flag=true;//true表示可以生产，false表示可以消费
    public Food() {
    }

    public Food(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    /**生产产品**/
    public synchronized void set(String name,String desc) {
        if (!flag){
            try {
                this.wait();//线程进入等待状态，释放监视器的所有权；
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.setName(name);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setDesc(desc);
        flag=false;
        this.notify();
    }

    /**消费产品**/
    public synchronized void get() {
        if (flag){
            try {
                this.wait();//线程进入等待状态，释放监视器的所有权；
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this);
        flag=true;
        this.notify();
    }

}



