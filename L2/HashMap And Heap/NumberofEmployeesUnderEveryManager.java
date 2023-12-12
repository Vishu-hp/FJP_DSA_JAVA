import java.util.*;

class Solution {
    private static void findCount(HashMap<String, String>map){
        HashMap<String, HashSet<String>> tree = new HashMap<>();
        String ceo = "";

        for(String emp: map.keySet()){
            String man = map.get(emp);

            if(man.equals(emp)){
                ceo = man;
            }
            else{
                if(tree.containsKey(man)){
                    HashSet<String> emps = tree.get(man);
                    emps.add(emp);
                }
                else{
                    HashSet<String> emps = new HashSet<>();
                    emps.add(emp);
                    tree.put(man, emps);
                }
            }
        }

        HashMap<String, Integer> result = new HashMap<>();
        getSize(tree, ceo, result);

        for(String emp: result.keySet()){
            System.out.println(emp + " -> " + result.get(emp));
        }

    }

    public static int getSize(HashMap<String, HashSet<String>>tree, String man, HashMap<String, Integer>result){
        if(tree.containsKey(man) == false){
            result.put(man, 0);
            return 1;
        }

        int sz = 0;
        for(String emp: tree.get(man)){
            int cs = getSize(tree, emp, result);
            sz += cs;
        }

        result.put(man, sz);
        return sz+1;
    }

    public static void main(String[] args) {
        HashMap<String, String> dataSet = new HashMap<>();
        dataSet.put("A", "C");
        dataSet.put("B", "C");
        dataSet.put("C", "F");
        dataSet.put("D", "E");
        dataSet.put("E", "F");
        dataSet.put("F", "F");

        findCount(dataSet);
    }
}
