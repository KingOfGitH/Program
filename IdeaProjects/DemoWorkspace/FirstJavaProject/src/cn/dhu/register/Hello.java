package cn.edu.dhu;

import java.util.ArrayList;
import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int flag =0;//获取登陆前数字指令
        int logflag;//获取登陆后数字指令
        String usr_admin;//用户输入
        String usr_pwd;//密码输入
        String usr_pwd_again;//注册时确认密码
        int usr_id =-1;//用户id用来校验用户账号密码
        ArrayList<User> users = new ArrayList<>();
        System.out.println("****欢迎注册登录系统****");
        while (flag!=3)
        {
            boolean temp1=false;
            boolean temp2=false;
            System.out.println("1.注册");
            System.out.println("2.登录");
            System.out.println("其他数字:退出");
            System.out.println("***请输入数字选择功能菜单***");
            while (!scanner.hasNextInt()) {
                System.out.println("***请输入数字选择功能菜单***");
                scanner.next();
            }//非指定内容继续输入
            switch (flag = scanner.nextInt()) {
                /***************************注册账号************************************/
                case 1:
                    /*********************注册用户名*********************/
                    do {
                        temp1=false;
                        System.out.println("请输入您的账号（由6-16位字母数字下划线组成）:");
                        while (!scanner.hasNext("\\w{6,16}")) {
                            System.out.println("用户名违规！！！请输入由6-16位字母数字下划线组成的账号:");
                            scanner.next();
                        }
                        usr_admin = scanner.next("\\w{6,16}");
                        for (int i = 0; i < User.getUserNum(); i++) {
                            if (users.get(i).getAdmin().equals(usr_admin)) {
                                System.out.println("用户名已存在！！！");
                                temp1=true;
                                break;
                            }
                        }
                    }while(temp1);
                    /*********************注册密码*********************/
                    do {
                        System.out.println("请输入您的密码（6-16位字符）:");
                        while (!scanner.hasNext(".{6,16}")) {
                            System.out.println("请输入6-16位字符组成的密码！！！:");
                            scanner.next();
                        }
                        usr_pwd=scanner.next(".{6,16}");
                        System.out.println("请确认您的密码:");
                        usr_pwd_again=scanner.next();
                        if(!usr_pwd.equals(usr_pwd_again)){
                            System.out.println("密码不一致，请重新输入！！！");
                        }
                    }while(!usr_pwd.equals(usr_pwd_again));
                    users.add(new User(usr_admin,usr_pwd));
                    System.out.println("恭喜您注册成功，请登录");
                /*****************************登陆用户***************************************/
                case 2:
                    System.out.println("请输入您的账号:");
                    if(scanner.hasNext())
                    {
                        usr_admin = scanner.next();
                    } else break;
                    for (int i = 0; i < User.getUserNum(); i++) {//获得uid
                        if (users.get(i).getAdmin().equals(usr_admin)) {
                            System.out.println("请输入您的密码:");
                            usr_id=i;
                            temp2=true;
                            break;
                        }
                    }
                    if (temp2) {
                        if (scanner.hasNext()) {
                            usr_pwd = scanner.next();
                        } else
                        {
                            System.out.println("密码输入出错");
                            break;
                        }
                        if(users.get(usr_id).getPassword().equals(usr_pwd)) {
                            System.out.printf("登陆成功，欢迎用户 %s 回归\n",usr_admin);
                            do {
                                System.out.println("1.查看用户ID");
                                System.out.println("2.查看用户人数");
                                System.out.println("3.修改用户密码");
                                System.out.println("其他数字:退出");
                                System.out.println("***尊敬的用户"+usr_admin+"请输入数字选择您要进行的操作***");
                                while (!scanner.hasNextInt()) {
                                    System.out.println("***尊敬的用户"+usr_admin+"请输入数字选择您要进行的操作***");
                                }//非指定内容继续输入
                                switch (logflag = scanner.nextInt()) {
                                    case 1:
                                        System.out.println("您的用户ID："+usr_id);break;
                                    case 2:
                                        System.out.println("已注册用户人数"+User.getUserNum());break;
                                    case 3:
                                        System.out.println("正在修改用户密码：请输入您的旧密码：");
                                        if (scanner.hasNext()) {
                                            usr_pwd = scanner.next();
                                        } else
                                        {
                                            System.out.println("密码输入出错");
                                            break;
                                        }
                                        if (users.get(usr_id).getPassword().equals(usr_pwd))
                                        {
                                            do{
                                            System.out.println("请输入您的新密码（6-16位字符）:");
                                            while (!scanner.hasNext(".{6,16}")) {
                                                System.out.println("请输入6-16位字符组成的密码！！！:");
                                                scanner.next();
                                            }
                                            usr_pwd=scanner.next(".{6,16}");
                                            System.out.println("请确认您的新密码:");
                                            usr_pwd_again=scanner.next();
                                            if(!usr_pwd.equals(usr_pwd_again)){
                                                System.out.println("密码不一致，请重新输入！！！");
                                            }
                                            }while(!usr_pwd.equals(usr_pwd_again));
                                            users.get(usr_id).setPassword(usr_pwd);
                                        }
                                        else
                                        {
                                            System.out.println("密码输入错误，返回上层菜单");
                                        }break;
                                    default:
                                        System.out.println("已登出，欢迎您再次登陆");
                                        System.out.println("即将返回功能菜单");
                                        logflag=4;
                                }
                            }while(logflag!=4);
                        }
                        else System.out.println("密码错误，请检查！！！即将返回功能菜单");
                    }
                    else System.out.println("用户名不存在，请检查！！！即将返回功能菜单");
                    break;
                default:
                    System.out.println("欢迎您再次使用本系统");
                    flag=3;
            }
        }

    }
}
