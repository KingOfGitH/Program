package com.dhu.xml;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XmlTest {

    /**
     * 输出xml文件
     * @throws FileNotFoundException
     */

    @Test
    public void xmlEnCoder() throws FileNotFoundException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream
                (new FileOutputStream("test.xml"));
        XMLEncoder xmlEncoder = new XMLEncoder(bufferedOutputStream);
        Person p =new Person();
        p.setPersonid("1212");
        p.setAddress("1212");
        p.setEmail("1212");
        p.setName("1212");
        p.setTel("1212");
        p.setFox("1212");
        xmlEncoder.writeObject(p);
        xmlEncoder.close();
    }

    /**
     * 从XML文件中读取对象
     */

    @Test
    public void xmlDeCoder() throws FileNotFoundException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream
                (new FileInputStream("test.xml"));
        XMLDecoder decoder =new XMLDecoder(bufferedInputStream);
        Person p = (Person) decoder.readObject();
        System.out.println(p);
    }

    /**
     * SAX解析的特点
     * 1基于事件驱动
     * 2顺序读取，速度快
     * 3不能任意读取，灵活性差
     * 4解析时占用的内存小
     * 5SAX更适应于在性能要求更高的设备上使用，例如安卓开发
     */
    @Test
    public void saxParseXml(){
        try {
//        1创建一个SAX解析器工厂对象
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
//        2通过工厂对象创建SAX解析器
            SAXParser saxParser = saxParserFactory.newSAXParser();
//        3创建一个数据处理器（需要我们自己编写）
            PersonHandleSAX personHandle=new PersonHandleSAX();
//        4开始解析
            InputStream is = Thread.currentThread().getContextClassLoader().
                    getResourceAsStream("com/dhu/xml/person.xml");
            saxParser.parse(is,personHandle);
            List<Person> people =personHandle.getPeople();
            for (Person p:people) {
                System.out.println(p);
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *DOM解析XML
     * 1基于树形结构，通过解析器一次性将文档加载到内存当中，所以会比较占内存，
     * 可以随机访问更加灵活，更适合在web开发中使用
     */

    @Test
    public void domParseXml() throws ParserConfigurationException, IOException, SAXException {
//        1创建一个DOM解析器工厂对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        2通过工厂对象创建SAX解析器
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
//        3解析文档
        InputStream is = Thread.currentThread().getContextClassLoader().
                getResourceAsStream("com/dhu/xml/person.xml");
//        此代码完成后，整个XML文档已被加载到内存中，以树状存储
        Document document = documentBuilder.parse(is);
//        4从内存中读取数据

//        获取节点名称为person的所有节点的集合
        NodeList personNodeList = document.getElementsByTagName("person");
        ArrayList<Person> person = new ArrayList<>();
        Person p=null;
//        此循环本次会循环两次
        for (int i = 0; i <personNodeList.getLength() ; i++) {
            Node personNode = personNodeList.item(i);
            p=new Person();
            String personid = personNode.getAttributes().
                    getNamedItem("personid").getNodeValue();
            p.setPersonid(personid);
//            获取当前节点的所有子节点
            NodeList childNodes = personNode.getChildNodes();
            for (int j = 0; j <childNodes.getLength() ; j++) {
                Node item = childNodes.item(j);
                String nodeName = item.getNodeName();
                if("name".equals(nodeName)){
                    p.setName(item.getFirstChild().getNodeValue());
                }else if("address".equals(nodeName)){
                    p.setAddress(item.getFirstChild().getNodeValue());
                }else if("tel".equals(nodeName)){
                    p.setTel(item.getFirstChild().getNodeValue());
                }else if("fax".equals(nodeName)){
                    p.setFox(item.getFirstChild().getNodeValue());
                }else if("email".equals(nodeName)){
                    p.setEmail(item.getFirstChild().getNodeValue());
                }
            }
            person.add(p);

        }
        for (Person person1:person) {
            System.out.println(person1.toString());
        }
    }

    /**
     * JDOM解析XML
     * 1 与DOM类似，基于树形结构，
     * 2 与DOM区别：
     *   第三方开源程序
     *   实现使用JAVA的Collection接口
     *   效率比DOM更快
     * @throws JDOMException
     * @throws IOException
     */

    @Test
    public void jdomParseXml() throws JDOMException, IOException {
//        创建JDOM解析器
        SAXBuilder builder =new SAXBuilder();
        InputStream is = Thread.currentThread().getContextClassLoader().
                getResourceAsStream("com/dhu/xml/person.xml");
        org.jdom2.Document build = builder.build(is);
        Element rootElement = build.getRootElement();
        ArrayList<Person> list = new ArrayList<>();
        Person person=null;
        List<Element> children = rootElement.getChildren();
        for (Element element:children) {
            List<Element> children1 = element.getChildren();
            person=new Person();
            person.setPersonid(element.getAttributeValue("person"));
            for (Element e :
                    children1) {
                String tar = e.getName();
                if("name".equals(tar)){
                    person.setName(e.getText());
                }else if("address".equals(tar)){
                    person.setAddress(e.getText());
                }else if("tel".equals(tar)){
                    person.setTel(e.getText());
                }else if("fax".equals(tar)){
                    person.setFox(e.getText());
                }else if("email".equals(tar)){
                    person.setEmail(e.getText());
                }
            }
            list.add(person);
            System.out.println(person.toString());
        }
    }

    /**
     * DOM4J解析
     * 基于树型结构，第三方组件
     * 解析速度快，效率更高，使用JAVA中的迭代器实现数据读取
     * 在WEB框架中华使用较多（Hibernate）
     * @throws DocumentException
     */
    @Test
    public void dom4jParseXml() throws DocumentException {
        SAXReader reader = new SAXReader();
        InputStream is = Thread.currentThread().getContextClassLoader().
                getResourceAsStream("com/dhu/xml/person.xml");
        org.dom4j.Document read = reader.read(is);
        org.dom4j.Element rootElement = read.getRootElement();
        Iterator iterator = rootElement.elementIterator();
        ArrayList<Person> people=new ArrayList<>();
        Person p=null;
        while (iterator.hasNext()){
            p =new Person();
            org.dom4j.Element next = (org.dom4j.Element) iterator.next();
            p.setPersonid(next.attributeValue("personid"));
            Iterator iterator1 = next.elementIterator();
            while (iterator1.hasNext()){
                org.dom4j.Element next1 = (org.dom4j.Element) iterator1.next();
                String tar = next1.getName();
                if("name".equals(tar)){
                    p.setName(next1.getText());
                }else if("address".equals(tar)){
                    p.setAddress(next1.getText());
                }else if("tel".equals(tar)){
                    p.setTel(next1.getText());
                }else if("fax".equals(tar)){
                    p.setFox(next1.getText());
                }else if("email".equals(tar)){
                    p.setEmail(next1.getText());
                }
            }
            people.add(p);
            System.out.println(p.toString());
        }
    }

    /**
     * 使用第三方组件XSTEAM进行xml的解析与生成
     */
    @Test
    public void xSteam(){
        Person p=new Person();
        p.setPersonid("1212");
        p.setAddress("1212");
        p.setEmail("1212");
        p.setName("1212");
        p.setTel("1212");
        p.setFox("1212");

//        生成XML
        XStream xStream = new XStream(new Xpp3Driver());
        xStream.alias("person",Person.class);
        xStream.useAttributeFor(Person.class,"personid");
        String xml = xStream.toXML(p);
        System.out.println(xml);
//        解析XML
        Person person = (Person) xStream.fromXML(xml);
        System.out.println(person);
    }

}
