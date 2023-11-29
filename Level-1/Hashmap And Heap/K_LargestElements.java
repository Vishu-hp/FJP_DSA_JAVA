import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int k = scn.nextInt();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int[] arr = {2,10,5,17,7,18,6,4};
        
        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }

        for(int i=k;i<arr.length;i++){
            if(arr[i] > pq.peek()){
                pq.remove();
                pq.add(arr[i]);
            }
        }

        while(pq.size() > 0){
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}
