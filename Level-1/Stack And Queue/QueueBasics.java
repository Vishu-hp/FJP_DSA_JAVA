import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        // Write your code here
        Queue<Integer> q = new ArrayDeque<>();

        q.add(10);
        System.out.println(q + "->"+ q.peek() + " " + q.size());
        q.add(20);
        System.out.println(q + "->"+ q.peek() + " " + q.size());
        q.add(30);
        System.out.println(q + "->"+ q.peek() + " " + q.size());

        q.remove();
        System.out.println(q + "->"+ q.peek() + " " + q.size());

    }   
}
