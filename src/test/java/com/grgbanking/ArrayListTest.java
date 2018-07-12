package com.grgbanking;

import com.grgbanking.linearlist.ArrayList;

/**
 * @author zxlei1
 * @version 1.0  2018年07月12日 zxlei1 create
 * @create 2018年07月12日 14:55
 * @copyright Copyright @2018 广电运通 All rights reserved.
 **/
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        System.out.println(list.size());
        System.out.println(list.toString());
        System.out.println(list.insert(1,"3"));
        System.out.println(list.toString());
        System.out.println(list.get(1));
        list.delete(1);
        System.out.println(list.toString());
    }
}
