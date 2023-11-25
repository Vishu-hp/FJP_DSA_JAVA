import java.io.*;
import java.util.*;

class Solution {
    public static class Node{
        int data;
        ArrayList<Node>children;

        Node(int val){
            data = val;
            children = new ArrayList<>();
        }
    }

    public static Node construct(Integer[] arr){
        Node root = new Node(arr[0]);

        Stack<Node>st = new Stack<>();
        st.push(root);
        int idx=1;

        while(idx < arr.length){
            if(arr[idx] == null){
                st.pop();
            }
            else{
                Node nc = new Node(arr[idx]);
                st.peek().children.add(nc);
                st.push(nc);
            }

            idx++;
        }

        return root;
    }

    static int ceil;
    static int floor;

    public static void ceilAndFloor(Node node, int data){
        if(node.data > data){
            if(node.data < ceil){
                ceil = node.data;
            }
        }

        if(node.data < data){
            if(floor < node.data){
                floor = node.data;
            }
        }

        for(Node child: node.children){
            ceilAndFloor(child);
        }
    }

    public static void main(String[] args) {
        // Write your code here
         Integer[] arr = {10,20,null,30,50,null,60,null,null,40,null,null};
         Node node = construct(arr);

        ceil = Integer.MAX_VALUE;  // Smallest among largest
        floor = Integer.MIN_VALUE;  // Largest among smallest
        ceilAndFloor(node, 55);
        System.out.println("ceil : " + ceil)
        System.out.println("floor : " + floor);
       


    }
}
