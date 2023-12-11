import java.util.*;

class Solution {
    public static void main(String[] args) {
       ArrayList<Integer>list = new ArrayList<>();

    //    add
    list.add(10);
    list.add(20);
    list.add(30);
    System.out.println(list + "-> " + list.size());

    list.add(1, 1000);
    System.out.println(list + "-> " + list.size());

    int val = list.get(1);
    System.out.println(val);

    list.set(1, 2000);
    System.out.println(list + "-> " + list.size());

    list.remove(1);
    System.out.println(list + "-> " + list.size());

    
    for(int i=0; i<list.size();i++){
        int val2 = list.get(i);
        System.out.println(val2);
    }

    for(int val3: list){
        System.out.println(val3);
    }

    System.out.println(list);

    }
}
