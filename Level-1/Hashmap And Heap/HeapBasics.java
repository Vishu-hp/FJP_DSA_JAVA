import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(); // Min Pq
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());// Max Pq
        int[] ranks = {22, 99, 3, 11, 88, 4, 1};

        for(int val: ranks){
            pq1.add(val);
            pq2.add(val);
        }

        while(pq1.size() > 0){
            System.out.println(pq1.peek());
            pq1.remove();
        }

        System.out.println();

        while(pq2.size() > 0){
            System.out.println(pq2.peek());
            pq2.remove();
        }

    }
}
