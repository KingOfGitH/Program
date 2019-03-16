package cn.dhu.ui;

import cn.dhu.bean.Clothes;
import cn.dhu.bean.Order;
import cn.dhu.bean.OrderItem;
import cn.dhu.service.ClothesService;
import cn.dhu.service.OrderService;
import cn.dhu.service.impl.ClothesServiceImpl;
import cn.dhu.service.impl.OrderServiceImpl;
import cn.dhu.utils.BusinessException;
import cn.dhu.utils.DataUtils;

import java.util.Date;
import java.util.List;

public class HomeClass extends BaseClass{
    private OrderService orderService=new OrderServiceImpl();
    private ClothesService clothesService=new ClothesServiceImpl();

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
                    try{
                        buyProduct();
                    }
                    catch (BusinessException e){
                        println(e.getMessage());
                    }
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

    /**
     * 购买商品
     * @throws BusinessException
     */
    private void buyProduct() throws BusinessException {
        //生成订单
        boolean flag=true;
        int count=0;
        float sum=0;
        Order order=new Order();
        while (flag){
            print(getString("product.input.id"));
            String id=input.nextLine();
            print(getString("product.input.shoppingNum"));
            int shoppingNum= Integer.parseInt(input.nextLine());
            OrderItem orderItem=new OrderItem();
            Clothes clothes=clothesService.findClothesById(id);
            if (shoppingNum>clothes.getNum()){
                throw new BusinessException("product.num.error");
            }
            clothes.setNum(clothes.getNum()-shoppingNum);//减去库存
            orderItem.setShoppingNum(shoppingNum);
            orderItem.setClothes(clothes);
            orderItem.setSum(clothes.getPrice()*shoppingNum);
            orderItem.setItemId(++count);
            sum+=orderItem.getSum();

            order.getOrderItemList().add(orderItem);

//            input.nextLine();//这里需要清除\n的缓存，不然下面的输入会无效。
//            但之后的输入还会出现问题，需要避免nextxx与nextLine混用
            println(getString("product.buy.continue"));
            String isBuy=input.nextLine();
            switch (isBuy){
                case "1":
                    break;
                case "2":
                    flag=false;
                    break;

                default:
                    flag=false;
                    break;
            }
        }
        order.setCreateData(DataUtils.toDate(new Date()));
        order.setUserId(currUser.getId());
        order.setOrderId(orderService.list().size()+1);
        order.setSum(sum);
        clothesService.update();
        showProducts();
    }

    private void findOrderById() {
    }

    private void findList() {

    }

    private void showProducts() {
        ClothesService clothesService=new ClothesServiceImpl();
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
