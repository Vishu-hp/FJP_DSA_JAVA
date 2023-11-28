import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        HashMap<Character, Integer>hm = new HashMap<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(hm.containsKey(ch)){
                int val = hm.get(ch);
                hm.put(ch, val+1);
            }
            else{
                hm.put(ch, 1);
            }
        }

        char mfc = str.charAt(2);
        for(char key: hm.keySet()){
            if(hm.get(key) > hm.get(mfc)){
                mfc = key;
            }
        }

        System.out.println(mfc);
    }
}
