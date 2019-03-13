package com.dhu.xml;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


import java.util.ArrayList;
import java.util.List;

public class PersonHandleSAX extends DefaultHandler {
    private List<Person> people = null;
    private Person person;
    private String tag;//用于记录当前正在保存的标签名

    public List<Person> getPeople() {
        return people;
    }

    //    开始解析文档时，解析器自动调用
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        people = new ArrayList<>();
        System.out.println("开始解析文档..");
    }
//     在xml文档解析结束时调用
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("解析文档解释。");
    }

    /**
     * 解析开始元素时调用
     * @param uri 命名空间
     * @param localName 不带前缀的标签
     * @param qName 带前缀的标签
     * @param attributes 当前标签的属性集合
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if ("person".equals(qName)){
            person = new Person();
            String personid=attributes.getValue("personid");
            person.setPersonid(personid);

        }
        tag=qName;

    }

    /**
     * 结束解析时调用
     * @param uri
     * @param localName
     * @param qName
     * @throws SAXException
     */
    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        super.endElement(uri, localName, qName);
        if ("person".equals(qName)) {
            people.add(person);
        }
        tag =null;
    }

    /**
     * 解析文本内容时调用
     * @param ch
     * @param start
     * @param length
     * @throws SAXException
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if (null!=tag){
            if ("name".equals(tag)){
                person.setName(new String(ch,start,length));
            }
            if ("address".equals(tag)){
                person.setAddress(new String(ch,start,length));
            }
            if ("tel".equals(tag)){
                person.setTel(new String(ch,start,length));
            }
            if ("fox".equals(tag)){
                person.setFox(new String(ch,start,length));
            }
            if ("eamil".equals(tag)){
                person.setEmail(new String(ch,start,length));
            }
        }
    }



}
