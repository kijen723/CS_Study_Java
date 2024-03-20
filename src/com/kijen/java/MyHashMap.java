package com.kijen.java;

import java.util.HashMap;

public class MyHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 1);
        map.put("d", 2);

        map.remove("a");
        System.out.println(map);
        System.out.println(map.get("b"));

        for (String value : map.keySet()) {
            System.out.print(value + " ");
        }
        System.out.println();

        for (Integer value : map.values()) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
