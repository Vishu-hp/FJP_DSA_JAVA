import java.util.*;

class Solution {
    public static void printResult(HashMap<String, String>hmp){
        String sp = "";

        HashMap<String, Boolean>mp2 = new HashMap<>();

        for(String src: hmp.keySet()){
            String des = hmp.get(src);

            mp2.put(des, false);

            if(mp2.containsKey(src) == false){
                mp2.put(src, true);
            }
        }

        for(String city: mp2.keySet()){
            boolean val = mp2.get(city);

            if(val){
                sp = city;
                break;
            }
        }

        while(true){
            if(mp2.containsKey(sp) == true){
                System.out.print(sp + "->");
                sp = hmp.get(sp);
            }
            else{
                System.out.print(sp + ".");
                break;
            }
            
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> dataSet = new HashMap<>();
        dataSet.put("Chennai", "Banglore");
        dataSet.put("Bombay", "Delhi");
        dataSet.put("Goa", "Chennai");
        dataSet.put("Delhi", "Goa");
 
        printResult(dataSet);
    }
}
