package org.popkit;

/**
 * @author guobao.jiang
 * @date 10/3/14
 * @time 12:50 AM
 */
public class MainFacade {
    public static void main(String[] args) {
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
