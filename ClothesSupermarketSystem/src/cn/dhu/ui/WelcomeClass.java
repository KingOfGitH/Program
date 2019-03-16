package cn.dhu.ui;

import cn.dhu.bean.User;
import cn.dhu.utils.BusinessException;
import cn.dhu.utils.UserIO;

public class WelcomeClass extends BaseClass{

    public void start(){
        println(getString("info.welcome"));
        UserIO userIO=new UserIO();
        userIO.readUsers();
        boolean flag=true;
        while (flag){
            println(getString("info.login.reg"));
            print(getString("info.select"));
            String select = input.nextLine();
            switch (select){
                case "1":
                    System.out.println("登陆");
                    try {
                        new LoginClass().login();
                        println(getString("login.success"));
                        flag=false;
                    }catch (BusinessException e){
                        println(getString(e.getMessage()));
                    }
                    break;
                case "2":

                    System.out.println("注册");
                    try {
                        new RegisterClass().register();
                        println(getString("reg.success"));
                        flag=false;
                    }catch (BusinessException e){
                        println(getString("reg.error"));
                    }

                    break;
                default:
                    println(getString("input.error"));
            }
        }
        new HomeClass().show();
    }
}
