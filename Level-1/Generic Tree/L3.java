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

    public static ArrayList<Integer> nodeToRootPath(Node node, int data){
        if(node.data == data){
            ArrayList<Integer>sa = new ArrayList<>();
            sa.add(data);
            return sa;
        }

        for(Node child: node.children){
            ArrayList<Integer>tmp = nodeToRootPath(child, data);
            if(tmp.size() > 0){
                tmp.add(node.data);
                return tmp;
            }
        }

        return new ArrayList<>();
    }

    public static int lca(Node node,int val1, int val2){
        ArrayList<Integer> al1 = nodeToRootPath(node, val1);
        ArrayList<Integer>al2 = nodeToRootPath(node, val2);

        int i1=al1.size()-1, i2= al2.size()-1;

        while(i1>=0 && i2>=0){
            if(al1.get(i1) == al2.get(i2)){
                i1--;
                i2--;
            }
            else{
                break;
            }
        }

        return al1.get(i1+1);
    }

    public static void removeLeaves(Node node){
        for(int idx= node.children.size()-1; idx>=0; idx--){
            Node tmp = node.children.get(idx);
            if(tmp.children.size() == 0){
                tmp.children.remove(idx);
            }
        }

        for(Node child: node.children){
            removeLeaves(child);
        }
    }

    private static Node getTail(Node node){
        while(node.children.size() == 1){
            node = node.children.get(0);
        }

        return node;
    }

    public static void linearize(Node node){
        for(Node child: node.children){
            linearize(child);
        }

        while(node.children.size() > 1){
            Node lc = node.children.remove(node.children.size() - 1);
            Node slc = node.children.get(node.children.size() - 1);

            Node tail = getTail(slc);
            tail.children.add(lc);
        }

        return;
    }

    public static int distanceBwTwoNodes(Node node,int d1, int d2){
        ArrayList<Integer>al1 = nodeToRootPath(node, d1);
        ArrayList<Integer>al2 = nodeToRootPath(node, d2);

        int i1=al1.size()-1, i2 = al2.size()-1;

        while(i1>=0 && i2>=0 && al1.get(i1) == al2.get(i2)){
            i1--;
            i2--;
        }

        i1++;
        i2++;

        return i1+i2;
    }

    public static void main(String[] args) {
        // Write your code here
         Integer[] arr = {10,20,null,30,50,null,60,null,null,40,null,null};
         Node node = construct(arr);

         ArrayList<Integer>a1 = nodeToRootPath(node, 50);
         System.out.println(a1);

         int a2 = lca(node, 50, 20);
         System.out.println(a2);

        int a3 = distanceBwTwoNodes(node, 20, 40);
         System.out.println(a3);


    }
}
