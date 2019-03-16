package cn.dhu.utils;

import cn.dhu.bean.Clothes;
import cn.dhu.bean.Order;

import java.util.ArrayList;
import java.util.List;

public class ClothesIO {

    private static List<Clothes> clothes=new ArrayList<>();

    public Clothes findClothesById(String cid) throws BusinessException {
        Clothes c;
        for (int i = 0; i < clothes.size(); i++) {
            if (clothes.get(i).getId().equals(cid)) {
                c=clothes.get(i);
                return c;
            }
        }
        return null;
    }

    public List<Clothes> list() throws BusinessException {
        if (0==clothes.size()) {
            clothes=ProductsXmlUtils.parserProductsXml();
        }
        return clothes;
    }

//    更新XML文件
    public void update() throws BusinessException{
        ProductsXmlUtils.writeProductsToXml(clothes);
    }
}
