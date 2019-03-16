package cn.dhu.utils;

import cn.dhu.bean.Clothes;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;

import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.beans.XMLDecoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductsXmlUtils {
    public static List<Clothes> parserProductsXml()  {

        List<Clothes> products =new ArrayList<>();
        try {
        XStream xStream = new XStream(new Xpp3Driver());
        xStream.alias("list",products.getClass());
        xStream.alias("clothes",Clothes.class);
        xStream.alias("list",products.getClass());
        xStream.useAttributeFor(Clothes.class,"id");
        BufferedInputStream bufferedInputStream = new BufferedInputStream
                (new FileInputStream("products.xml"));
        products = (List<Clothes>) xStream.fromXML(bufferedInputStream);
        bufferedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;

    }

    public static void writeProductsToXml( List<Clothes> products) {
        try {
        XStream xStream = new XStream(new Xpp3Driver());
        xStream.alias("list",products.getClass());
        xStream.alias("clothes",Clothes.class);
        xStream.alias("list",products.getClass());
        xStream.useAttributeFor(Clothes.class,"id");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
                new FileOutputStream("products.xml"));
        bufferedOutputStream.write("<?xml version=\"1.0\" encoding=\"utf-8\" ?>".getBytes());
        xStream.toXML(products,bufferedOutputStream);
        bufferedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
