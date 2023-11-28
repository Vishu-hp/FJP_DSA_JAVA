
import java.io.*;
import java.util.*;

class Main {
    public static class Node{
        int data;
        Node left, right;

        Node(int val){
            data= val;
            left= right= null;
        }
    }

    public static class Pair{
        Node node;
        int state;

        Pair(Node node){
            this.node = node;
        }
    }

    public static Node construct(Integer arr[]){
        Node root = new Node(arr[0]);
        Stack<Pair>st = new Stack<>();
        st.push(new Pair(root));
        int idx = 1;
        while(st.size() > 0){
            Pair tpair = st.peek();
            if(st.peek().state == 0){
                Integer val = arr[idx++];
                
                if(val != null){
                    Node nd = new Node(val);
                    tpair.node.left = nd;
                    st.push(new Pair(nd));    
                }
                tpair.state++;
            }
            else if(st.peek().state == 1){
                Integer val = arr[idx++];
                
                if(val != null){
                    Node nd = new Node(val);
                    tpair.node.right = nd;
                    st.push(new Pair(nd));
                }
                tpair.state++;
            }
            else{
                st.pop();
            }
        }

        return root;
    }

     public static void display(Node node){
        if(node == null){
            return;
        }

        if(node.left != null){
            System.out.print(node.left.data);
        }
        else{
            System.out.print(".");
        }

        System.out.print(" <- " + node.data + " -> ");

         if(node.right != null){
            System.out.print(node.right.data);
        }
        else{
            System.out.print(".");
        }
        
        System.out.println();

        display(node.left);
        display(node.right);
    } 

    public static Node removeLeaves(Node node){
        if(node == null){
            return null;
        }

        if(node.left == null && node.right == null){
            return null;
        }

        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);

        return node;
    }

    static int tilt=0;
    public static int tiltCalc(Node node){
        if(node == null){
            return 0;
        }

        int ls = tiltCalc(node.left);
        int rs = tiltCalc(node.right);

        tilt += Math.abs(ls - rs);

        return ls + rs + node.data;
    }

    static int dia = 0;
    public static int diameter(Node node){
        if(node == null){
            return -1;
        }

        int lht = diameter(node.left);
        int rht = diameter(node.right);

        dia = Math.max(dia, lht+rht+2);

        return Math.max(lht, rht) + 1;
    }

    public static void main(String[] args) {
        Integer arr[] = {10,20,40,null,null,50,70,null,null,null,30,null,60,null,null};
        Node root = construct(arr);
        // display(root);
        // System.out.println();

        // removeLeaves(root);
        // display(root);

        tiltCalc(root);
       System.out.println(tilt);
       
       diameter(root);
       System.out.println(dia);
    }
}
