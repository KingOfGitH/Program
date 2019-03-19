package hello;

public class MessageService {

    public MessageService() {
        super();
        System.out.println("MessageService...");
    }

    /**
     * 执行打印功能
     * @return 返回要打印的字符
     */
    public String getMessage(){
        return "Hello World!";
    }
}
