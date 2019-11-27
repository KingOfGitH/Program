package cn.edu.wangyi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class Test {
    public static void main(String[] args) throws ParseException {
//        Calendar now = Calendar.getInstance();
//        System.out.println("年: " + now.get(Calendar.YEAR)%100);
//        System.out.println("月: " + (now.get(Calendar.MONTH) + 1) + "");
//        System.out.println("日: " + now.get(Calendar.DAY_OF_MONTH));
//        System.out.println("时: " + now.get(Calendar.HOUR_OF_DAY));
//        System.out.println("分: " + now.get(Calendar.MINUTE));
//        System.out.println("秒: " + now.get(Calendar.SECOND));
//        System.out.println("当前时间毫秒数：" + now.getTimeInMillis());
//        System.out.println(now.getTime());
//
//        Date d = new Date();
//        System.out.println(d);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String dateNowStr = sdf.format(d);
//        System.out.println("格式化后的日期：" + dateNowStr);
//
//        String str = "2012-1-13 17:26:33";	//要跟上面sdf定义的格式一样
//        Date today = sdf.parse(str);
//        System.out.println("字符串转成日期：" + today);
        System.out.println(change36To10("zz"));
        System.out.println(Integer.MAX_VALUE%change36To10("zzzzzz"));
        System.out.println(System.currentTimeMillis());
        System.out.println(change(System.currentTimeMillis()));
        System.out.println(longToDate(change36To10("zzzzzzzz")));
        //(10)获取一个随机数生成器
//        ThreadLocalRandom random =  ThreadLocalRandom.current();
//
//        StringBuilder builder=new StringBuilder();
//        builder.append(1);
//        builder.append("sfdsdfr");
//        System.out.println(builder);
//        System.out.println(builder.toString());
//        System.out.println(String.valueOf(builder));
        //(11)输出10个在0-5（包含0，不包含5）之间的随机数
//        for (int i = 0; i < 30; ++i) {
//            System.out.print(random.nextInt(36));
//            System.out.print(random.nextInt(36));
//            System.out.print(random.nextInt(36));
//            System.out.print(random.nextInt(36));
//            System.out.print(random.nextInt(36));
//            System.out.println(random.nextInt(36));
//        }
//        System.out.println("sfdsdfr".substring(2,7));


        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        System.out.println(sdf.format(new Date()).length());
    }

    public static String change(long num) {
        int f=10;
        int t=36;
        return new java.math.BigInteger(String.valueOf(num), f).toString(t);
    }

    public static long change36To10(String num) {
        int f=36;
        int t=10;
        return Long.parseLong(new java.math.BigInteger(num, f).toString(t));
    }
    public static String longToDate(long lo){
        Date date = new Date(lo);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sd.format(date);
    }
}