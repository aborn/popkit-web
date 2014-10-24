package org.popkit;


import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author guobao.jiang
 * @date 10/3/14
 * @time 12:50 AM
 */
public class MainFacade {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("abc", "abcvalue");
            jsonObject.put("abc", "abc2");
            jsonObject.put("abc", "abc3");
            jsonObject.put("abc", "abc4");
            System.out.println(jsonObject.toString());
        } catch (JSONException e) {

        }


        String hel = "Hello";
        String say = "Hi," + hel + "world!";
        System.out.println(say);
        StringBuilder strb = new StringBuilder();
        strb.append("Hi,");
        strb.append(hel);
        strb.append("world!");
        String sayNew = strb.toString();
        System.out.println(sayNew);
    }
}
