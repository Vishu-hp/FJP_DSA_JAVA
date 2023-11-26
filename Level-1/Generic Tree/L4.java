import java.io.*;
import java.util.*;

class Main {
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
            ceilAndFloor(child, data);
        }
    }

    public static int kthLargest(Node node, int k){
        floor = Integer.MIN_VALUE;
        int factor = Integer.MAX_VALUE;
        for(int i=0;i<k;i++){
            ceilAndFloor(node, factor);
            factor = floor;
            floor = Integer.MIN_VALUE;
        }

        return factor;
    }

    static int ans = 0;

    public static int diameter(Node node){
        int lh = -1, slh = -1;

        for(Node child: node.children){
            int cht = diameter(child);

            if(cht > lh){
                slh = lh;
                lh = cht;
            }
            else if(cht > slh){
                slh = cht;
            }
        }

        int diaNode = lh + slh + 2;
        ans = Math.max(ans, diaNode);
        return lh+1;
    }

    public static boolean areMirror(Node n1, Node n2){
        if(n1.children.size() != n2.children.size()){
            return false;
        }

        for(int i=0; i<n1.children.size(); i++){
            Node c1 = n1.children.get(i);

            int j = n1.children.size() - 1 - i;
            Node c2 = n2.children.get(j);

            if(areMirror(c1, c2) == false){
                return false;
            }
        }

        return true;
    }

    public static boolean isSymmetric(Node node){
        return areMirror(node, node);
    }

    public static void main(String[] args) {
        // Write your code here
         Integer[] arr = {10,20,null,30,50,null,60,null,null,40,null,null};
         Node node = construct(arr);

       /* ceil = Integer.MAX_VALUE;  // Smallest among largest
        floor = Integer.MIN_VALUE;  // Largest among smallest
        ceilAndFloor(node, 55);
        System.out.println("ceil : " + ceil)
        System.out.println("floor : " + floor); */
       
        System.out.println(kthLargest(node, 3));

        diameter(node);
        System.out.println(ans);
        
        System.out.println(isSymmetric(node));
    }
}
