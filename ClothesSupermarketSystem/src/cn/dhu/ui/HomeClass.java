package cn.dhu.ui;

import cn.dhu.bean.Clothes;
import cn.dhu.service.ClothesService;
import cn.dhu.service.impl.CLothesServiceImpl;

import java.util.List;

public class HomeClass extends BaseClass{

    public void show(){
        showProducts();
        println("welcome:"+currUser.getUsername());
        boolean flag = true;
        while (flag){
            println(getString("home.function"));
            println(getString("info.select"));
            String select=input.nextLine();
            switch(select){
                case"1"://查询全部订单
                    findList();
                    break;
                case "2"://查找订单
                    findOrderById();
                    break;
                case"3"://购买
                    buyProduct();
                    break;
                case "0":
                    flag=false;
                    System.exit(0);
                    break;
                default:
                    System.out.println(getString("input.error"));
                    break;
            }
        }
    }

    private void buyProduct() {
    }

    private void findOrderById() {
    }

    private void findList() {

    }

    private void showProducts() {
        ClothesService clothesService=new CLothesServiceImpl();
        List<Clothes> list=clothesService.list();
        ConsoleTable t = new ConsoleTable(8, true);
        t.appendRow();
        t.appendColum("id").
                appendColum("brand").
                appendColum("style").
                appendColum("color").
                appendColum("size").
                appendColum("num").
                appendColum("price").
                appendColum("description");
        for (int i = 0; i < list.size(); i++) {
            t.appendRow();
            t.appendColum(list.get(i).getId()).
                    appendColum(list.get(i).getBrand()).
                    appendColum(list.get(i).getStyle()).
                    appendColum(list.get(i).getColor()).
                    appendColum(list.get(i).getSize()).
                    appendColum(list.get(i).getNum()).
                    appendColum(list.get(i).getPrice()).
                    appendColum(list.get(i).getDescription());
        }
        System.out.println(t.toString());
    }
}
