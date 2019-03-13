package cn.dhu.communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.management.MemoryType;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.SplittableRandom;
import java.util.Vector;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**服务器端**/

public class Server {
    public static void main(String[] args) {
        Vector<UserThread> vector= new Vector<>();
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        try {
            ServerSocket serverSocket = new ServerSocket(1024);
            System.out.println("服务器已启动，正在等待连接...");
            while (true){
                Socket socket=serverSocket.accept();
                UserThread userThread=new UserThread(socket,vector);
                executorService.execute(userThread);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

/**
 * 客户端处理线程
 */
class UserThread implements Runnable{
    private String name;//唯一标识名称
    private Socket socket;//
    private Vector<UserThread> vector;//客户端处理线程集合
    private ObjectInputStream ois;//
    private ObjectOutputStream oos;//
    private boolean flag=true;//

    public UserThread(Socket socket, Vector<UserThread> vector) {
        this.socket = socket;
        this.vector = vector;
        vector.add(this);
    }

    @Override
    public void run() {
        System.out.println("客户端"+socket.getInetAddress().getHostAddress()+"已连接");
        try {
            ois =new ObjectInputStream(socket.getInputStream());
            oos =new ObjectOutputStream(socket.getOutputStream());
            while (flag){
                Message msg=(Message)ois.readObject();
                int type=msg.getType();
                switch (type){
                    case MessageType.TYPE_SEND:
                        String to =msg.getTo();
                        UserThread ut;
                        for (int i=0;i<vector.size();i++){
                            ut=vector.get(i);
                            if (to.equals(ut.name) && ut!=this){
                                ut.oos.writeObject(msg);
                                break;
                            }
                        }
                        break;
                    case MessageType.TYPE_LOGIN:
                        name=msg.getFrom();
                        msg.setInfo("欢迎您");
                        oos.writeObject(msg);
                        break;
                }
            }
            ois.close();
            oos.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
