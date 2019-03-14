package com.dhu.json;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import org.junit.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class createJsonTest {

    /**
     * 创建Json
     */
    @Test
    public void createJson(){
        ArrayList<Names> list = new ArrayList<>();
        list.add(new Names("fn1","ln1","e1"));
        list.add(new Names("fn2","ln2","e2"));
        JsonArray array = new JsonArray();
        for (Names n :
                list) {
            JsonObject object = new JsonObject();
            object.addProperty("firstName",n.getFirstName());
            object.addProperty("lastName",n.getLastName());
            object.addProperty("email",n.getEmail());
            array.add(object);
        }
        System.out.println(array.toString());
    }
    /**
     * GSON1
     * 把一个json对象转换为java类对象，或反过来
     */
    @Test
    public void gson1(){
        Gson gson=new Gson();
        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/dhu/json/name.json");
        InputStreamReader in = new InputStreamReader(is);
        Names names= gson.fromJson(in , Names.class);
        System.out.println(names);

        System.out.println(gson.toJson(names));
    }

    /**
     * gson2
     * 把一组java类对象转换为json对象或者反之
     */

    @Test
    public void gson2(){
        Gson gson=new Gson();
        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/dhu/json/names.json");
        InputStreamReader in = new InputStreamReader(is);

        TypeToken<List<Names>> typeToken = new TypeToken<List<Names>>(){};
        List<Names> list= gson.fromJson(in , typeToken.getType());
        System.out.println(list);

        System.out.println(gson.toJson(list,typeToken.getType()));
    }
}
