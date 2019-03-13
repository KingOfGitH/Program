package com.dhu.xml;


import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PersonTest {


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

}
