import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        HashMap<String, Integer>hm = new HashMap<>();

        hm.put("India", 135);
        hm.put("China", 200);
        hm.put("Pak", 50);
        hm.put("US",25);
        hm.put("UK",75);

        System.out.println(hm);

        hm.put("Nigeria", 10);
        hm.put("US", 35);
        System.out.println(hm);

        System.out.println(hm.get("US"));
        System.out.println(hm.get("Utopia"));

        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("Wakanda"));

        Set<String>keys = hm.keySet();
        System.out.println(keys);

        for(String key: hm.keySet()){
            int val = hm.get(key);
            System.out.println(key + " " + val);
        }
    }
}
