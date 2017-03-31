package com;

import com.test.util.HttpClients;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/2/23.
 */
public class App {
    public static void main(String[] args) throws JSONException {
//        String str = HttpClients.get("https://guoan-t.9h-sports.com/users/getNewYearRecord?user_id=111111&getTime=2017-02-20");
//        JSONObject jsonObject = new JSONObject(str);
//        String string = jsonObject.getString("message");
//        System.out.println(string);
//        System.out.println("====================");
//        HashMap<String,Object> map = new HashMap<String, Object>();
//        map.put("nhId","a045de4e-1c57-485c-86e9-f4cb18d44a5f");
//        map.put("itemTypeKey","SupplementaryCard");
//        map.put("count","1");
//        JSONObject jsonObject1 = new JSONObject(map);
//        String string1 = HttpClients.post("https://guoan-t.9h-sports.com/users/items/add",jsonObject1.toString());
//        JSONObject jsonObject2 = new JSONObject(string1);
//        System.out.println(string1);
//        System.out.println(jsonObject2.getString("oper_code")+"-----------");
        String str = HttpClients.get("https://guoan-t.9h-sports.com/users/getNewYearRecord?user_id=111111&getTime=2017-02-20");
        JSONObject jsonObject = new JSONObject(str);
        String string = jsonObject.getString("message");
        System.out.println(string);
        System.out.println("====================");
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("nhId","a045de4e-1c57-485c-86e9-f4cb18d44a5f");
        map.put("itemTypeKey","SupplementaryCard");
        map.put("count","1");
        JSONObject jsonObject1 = new JSONObject(map);
        String string1 = HttpClients.post("https://guoan-t.9h-sports.com/users/items/add",jsonObject1.toString());
        JSONObject jsonObject2 = new JSONObject(string1);
        System.out.println(string1);
        System.out.println(jsonObject2.getString("oper_code")+"-----------");

    }
}
