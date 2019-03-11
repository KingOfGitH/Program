package cn.dhu.ball;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ShuangSeBall {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        Random r=new Random();
        int[] userRedBall =new int[6];//用户选择红球
        int[] sysRedBall =new int[6];//系统随机产生红球，抽奖用
        int userBlueBall =0;//用户蓝色球
        int sysBlueBall =0;//系统随机蓝色球，抽奖用
        int redCount =0;//正确红球数
        int blueCount =0;//正确蓝球数
        int[] redBall =new int[33];//存放红球1-33号码
        for (int i=0;i<33;i++){
            redBall[i]=i+1;
        }
        boolean flag=true;
        System.out.println("双色球游戏开始，祝你好运");
        while (flag){
            System.out.print("请问你是机选还是手选？输入：1，机选；2，手选:");
            if (input.hasNextInt()){
                switch (input.nextInt()){
                    case 1:
                        //机选
                        sysBall(redBall,userRedBall);
                        userBlueBall=r.nextInt(16)+1;
                        flag=false;
                        break;
                    case 2:
                        System.out.println("请依次选择6个不同的红球(1-33)");
                        for (int i=0;i<6;){
                            System.out.printf("正在选第%d个红球(1-33)\n",i+1);
                            if (input.hasNextInt()){
                                userRedBall[i]=input.nextInt();
                                if(userRedBall[i]<=33 && userRedBall[i]>=1){
                                    int j;
                                    /**提示用户已经存在的球，避免重复选择**/
                                    System.out.print("已选择红球:");
                                    for (j=0;j<i;j++){
                                        System.out.print(userRedBall[j]+"、");
                                    }
                                    /**校验新选择的球是否重复，若重复直接跳出**/
                                    for (j=0;j<i;j++){
                                        if(userRedBall[i]==userRedBall[j]){
                                            break;
                                        }
                                    }
                                    if (j==i) i++;//如果循环完成仍未跳出，则录入并开始下一次选择
                                    else System.out.println("选球重复，请重新选择！！！");
                                }else {//输入不在范围内
                                    System.out.println("没有这种球，请重选");
                                }
                            }else{
                                input.next();//输入非数字
                                System.out.println("没有这种球，请重选");
                            }
                        }
                        while (flag){
                            System.out.print("请再选择蓝球(1-16):");
                            if (input.hasNextInt()){
                                userBlueBall=input.nextInt();
                                if(userBlueBall<=16 && userBlueBall>=1){
                                    break;//如果输入正确，则进行下一步
                                }else {//输入超出范围
                                    System.out.println("没有这种球，请重选");
                                }
                            }
                            else {//输入非数字
                                input.next();
                                System.out.println("没有这种球，请重选");
                            }
                        }
                        flag=false;
                        break;
                    default:
                        break;
                }
            }else {//输入非数字，没有这种菜单
                input.next();
            }
        }



        //产生中奖号码，由系统随机生成
        //红球
        sysBall(redBall,sysRedBall);
        //蓝球
        sysBlueBall=r.nextInt(16)+1;




        //统计蓝球中奖个数
        if (sysBlueBall==userBlueBall){
            blueCount++;
        }
        //统计红球中奖个数
        for (int i=0;i<6;i++){
            for (int j=0;j<6-redCount;j++){
                if(userRedBall[i]==sysRedBall[j]){
                    redCount++;
                    sysRedBall[j]=sysRedBall[j]+sysRedBall[5-redCount] -
                            (sysRedBall[5-redCount]=sysRedBall[j]);
                    break;
                }
            }
        }




        //验证是否中奖
        if (0==blueCount && 3>=redCount) {
            System.out.println("谢谢惠顾");
        }else if (1==blueCount && 3>redCount){
            System.out.println("六等奖：单注奖金固定为5元");
        }else if (1==blueCount && 3==redCount || 0==blueCount && 4==redCount){
            System.out.println("五等奖：单注奖金固定为10元");
        }else if (1==blueCount && 4==redCount || 0==blueCount && 5==redCount){
            System.out.println("四等奖：单注奖金固定为200元");
        }else if (1==blueCount && 5==redCount){
            System.out.println("三等奖：单注奖金固定为3000元");
        }else if (0==blueCount && 6==redCount){
            System.out.println("二等奖：奖金总额为当期高奖级奖金的25%，单注奖金按注均分，单注最高限额封顶500万元");
        }else if (1==blueCount && 6==redCount){
            System.out.println("一等奖：单注最高限额封顶500万元");
        }else {
            System.out.println("系统出错");
        }


        //打印输出信息
        MaoPaoSort(sysRedBall);
        MaoPaoSort(userRedBall);
        System.out.println("本期中奖红球号码为："+ Arrays.toString(sysRedBall));
        System.out.println("本期中奖蓝球号码为："+sysBlueBall);
        System.out.println("您的红球号码为："+Arrays.toString(userRedBall));
        System.out.println("您的蓝球号码为："+userBlueBall);
        System.out.println("您的红球中奖个数为："+redCount);
        System.out.println("您的蓝球中奖个数为："+blueCount);


    }



    /**由系统随机产生红球**/
    public static void sysBall(int[] redBall,int[] usrRedBall){
        Random r =new Random();
        int index=-1;
        for (int i=0;i<usrRedBall.length;i++){
            index=r.nextInt(redBall.length-i);
            usrRedBall[i]=redBall[index];
            redBall[index]=redBall[index]+redBall[redBall.length-i-1]-
                    (redBall[redBall.length-i-1]=redBall[index]);
        }
    }




    //冒泡排序
    public static void MaoPaoSort(int[] nums){//稳定的排序算法
        int temp;
        for (int i=0;i<nums.length-1;i++) {
            for (int j=0;j<nums.length-1-i;j++){
                if(nums[j]>nums[j+1]){
                    temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
    }
}
