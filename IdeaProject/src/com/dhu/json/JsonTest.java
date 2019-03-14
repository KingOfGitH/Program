package com.dhu.json;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class JsonTest {
    /**
     * 解析一个JSON数组
     */
    @Test
    public void parseJsonNames() throws IOException {
        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/dhu/json/names.json");
        InputStreamReader in = new InputStreamReader(is);
//        JSON的解析工具（解析器）
        JsonReader jsonReader = new JsonReader(in);
        ArrayList<Names> list=new ArrayList<>();

        jsonReader.beginArray();
        while (jsonReader.hasNext()){
            list.add(parseName(jsonReader));
        }
        jsonReader.endArray();
        System.out.println(Arrays.toString(list.toArray()));

    }
//    解析内容
    private Names parseName(JsonReader jsonReader) throws IOException {
        Names names=null;
        jsonReader.beginObject();
        names=new Names();
        while (jsonReader.hasNext()){
            String attrName = jsonReader.nextName();
            if ("firstName".equals(attrName)){
                names.setFirstName(jsonReader.nextString());
            } else if ("lastName".equals(attrName)){
                names.setLastName(jsonReader.nextString());
            } else if ("email".equals(attrName)){
                names.setEmail(jsonReader.nextString());
            }else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return names;
    }

    /**
     * 使用Json解决复杂的问题
     * @throws IOException
     */
    @Test
    public void parseJsonMessage() throws IOException {
        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/dhu/json/message.json");
        InputStreamReader in = new InputStreamReader(is);
        JsonReader jsonReader = new JsonReader(in);
        ArrayList<Message> list=readerMessageArray(jsonReader);
        System.out.println(Arrays.toString(list.toArray()));
        in.close();
        is.close();


    }

    private ArrayList<Message> readerMessageArray(JsonReader jsonReader) throws IOException {
        ArrayList<Message> list=new ArrayList<>();
        jsonReader.beginArray();
        while (jsonReader.hasNext()){
            list.add(readerMessage(jsonReader));
        }
        jsonReader.endArray();

        return list;
    }

//    解析一个Message对象
    private Message readerMessage(JsonReader jsonReader) throws IOException {
        Message message=new Message();
        jsonReader.beginObject();
        while (jsonReader.hasNext()){
            String attrName = jsonReader.nextName();
            if ("id".equals(attrName)){
                message.setId(jsonReader.nextLong());
            } else if ("text".equals(attrName)){
                message.setText(jsonReader.nextString());
            } else if ("geo".equals(attrName) && JsonToken.NULL!=jsonReader.peek()){
                message.setGeo(readDoubleGeo(jsonReader));
            }else if ("user".equals(attrName)){
                message.setUser(readUser(jsonReader));
            }else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return message;
    }

    /**
     * 解析User方法
     * @param jsonReader
     * @return
     */
    private User readUser(JsonReader jsonReader) throws IOException {
        User user = new User();
        jsonReader.beginObject();
        while (jsonReader.hasNext()){
            String attrName = jsonReader.nextName();
            if ("name".equals(attrName)){
                user.setName(jsonReader.nextString());
            } else if ("followers_count".equals(attrName)){
                user.setFollowers_count(jsonReader.nextInt());
            }else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return user;
    }

    /**
     * 解析GEO
     * @param jsonReader
     * @return
     */
    private ArrayList<Double> readDoubleGeo(JsonReader jsonReader) throws IOException {
        ArrayList<Double> geo=new ArrayList<>();
        jsonReader.beginArray();
        while (jsonReader.hasNext()){
            geo.add(jsonReader.nextDouble());
        }
        jsonReader.endArray();
        return geo;
    }
}
