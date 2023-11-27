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


    // CONSTRUCT USING RECUSRION
    static int idx;
    public static Node constructRec(Integer arr[]){
        if(arr[idx] == null){
            idx++;
            return null;
        }

        Node node = new Node(arr[idx++]);
        node.left = constructRec(arr);
        node.right = constructRec(arr);

        return node;
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

    public static int size(Node node){
        if(node == null){
            return 0;
        }

        return size(node.left) + size(node.right) + 1;
    }

    public static int sum(Node node){
        if(node == null){
            return 0;
        }

        return sum(node.left) + sum(node.right) + node.data;
    }

    public static int height(Node node){
        if(node == null){
            return -1;
        }

        return Math.max(height(node.left) , height(node.right)) + 1;
    }

    public static int maxInTree(Node node){
        if(node == null){
            return Integer.MIN_VALUE;
        }

        return Math.max(node.data, Math.max(maxInTree(node.left), maxInTree(node.right)));
    }

    public static void main(String[] args) {
        Integer arr[] = {10,20,40,null,null,50,70,null,null,null,30,null,60,null,null};
        Node root = construct(arr);

        idx = 0;
        Node rootRec = constructRec(arr);

        // display(root);
        // System.out.println();
        // display(rootRec);

        System.out.println("Size of bt: " + size(root));
        System.out.println("Sum of bt: " + sum(root));
        System.out.println("Height of bt: " + height(root));
        System.out.println("Max of bt: " + maxInTree(root));
        
    }
}
