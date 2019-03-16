package cn.dhu.test;

import cn.dhu.bean.Clothes;
import cn.dhu.utils.ProductsXmlUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;



public class ProductsXmlUtilsTest {
    @Test
    public void parserProductsXml() {
        List<Clothes> clothes= ProductsXmlUtils.parserProductsXml();
        System.out.println(Arrays.toString(clothes.toArray()));
    }

    @Test
    public void writeProductsToXml() {

    }
}
