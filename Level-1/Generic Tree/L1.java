package generic_tree;

import java.util.*;
public class L1 {
    private static class Node{
        int data;
        ArrayList<Node>children;

        Node(int val){
            data= val;
            children = new ArrayList<>();
        }
    }

    public static Node constructGt(Integer[] arr){
        Stack<Node>st = new Stack<>();
        Node root = new Node(arr[0]);
        st.push(root);
        int idx=1;

        while(idx < arr.length){
            Integer vl = arr[idx];

            if(vl == null){
                st.pop();
            }
            else{
                Node node = new Node(vl);
                Node par = st.peek();
                par.children.add(node);
                st.push(node);
            }

            idx++;
        }

        return root;
    }

    public static void display(Node node){
        System.out.print(node.data + "-> ");

        for(Node child: node.children){
            System.out.print(child.data + " ");
        }
        System.out.println();

        for(Node child: node.children){
            display(child);
        }
    }

    public static int size(Node node){
        int cnt=0;

        for(Node child: node.children){
            cnt += size(child);
        }

        return cnt+1;
    }

    public static int max(Node node){
        int maxVal=Integer.MIN_VALUE;

        for(Node child: node.children){
            int faith = max(child);
            maxVal = Math.max(maxVal, faith);
        }

        maxVal = Math.max(maxVal, node.data);

        return maxVal;
    }

    public static int height(Node node){
        int ht = -1;

        for(Node child: node.children){
            int ch = height(child);
            ht = Math.max(ch, ht);
        }

        ht += 1;
        return ht;
    }

    public static void main(String[] args) {
        Integer[] arr = {10,20,null,30,50,null,60,null,null,40,null,null};
        Node root = constructGt(arr);
        display(root);
        System.out.println(size(root));
        System.out.println(max(root));
        System.out.println(height(root));
    }
}
