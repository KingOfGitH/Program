package hello;


public class Application {
    public static void main(String[] args){
        System.out.println("application");
        MessagePrinter printer=new MessagePrinter();//创建打印机对象
        MessageService service=new MessageService();
        printer.setService(service);//设置打印机对象的service属性
        printer.printMessage();
    }
}
