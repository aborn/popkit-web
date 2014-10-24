package org.popkit;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

        List<Integer> intList = new ArrayList<Integer>();
        intList.add(4);
        intList.add(1);
        intList.add(5);
        intList.add(2);
        intList.add(90);

        System.out.println(intList.toString());

        Collections.sort(intList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;      // 从小到大排序
            }
        });

        System.out.println(intList.toString());

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
