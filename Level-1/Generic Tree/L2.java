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

    public static void levelOrder(Node root){
        Queue<Node>q = new ArrayDeque<>();
        q.add(root);

        while(q.size() > 0){
            Node rem = q.remove();

            System.out.print(rem.data + " ");

            for(Node child: rem.children){
                q.add(child);
            }
        }

        System.out.println(".");
        return;
    }

    public static void levelOrderLinewise(Node node){
        // APPROACH 1 - SINGLE QUEUE
         Queue<Node>q = new ArrayDeque<>();
        q.add(node);

        while(q.size() > 0){
            int size = q.size();
            for(int i=0; i<size; i++){
                Node rem = q.remove();
                System.out.print(rem.data + " ");

                for(Node child: rem.children){
                    q.add(child);
                }
            }
            System.out.println();
        } 

        System.out.println();

        // APPROACH 2 - 2 QUEUES
        Queue<Node>cq = new ArrayDeque<>();
        Queue<Node>nq = new ArrayDeque<>();

        cq.add(node);
        while(cq.size() > 0){
            Node rem = cq.remove();

            System.out.print(rem.data + " ");

            for(Node child: rem.children){
                nq.add(child);
            }

            if(cq.size() == 0){
                System.out.println();
                cq = nq;
                nq = new ArrayDeque<>();
            }
        }
    }

    public static void levelOrderZigZag(Node node){
        Stack<Node>cl = new Stack<>();
        Stack<Node>nl = new Stack<>();
        int level = 0;
        cl.push(node);
        while(cl.size() > 0){
            Node rem = cl.pop();

            System.out.print(rem.data + " ");

            if(level%2 == 0){
                for(Node child: rem.children){
                    nl.push(child);
                }
            }
            else{
                for(int idx = rem.children.size()-1; idx>=0; idx--){
                    Node nd = rem.children.get(idx);
                    nl.push(nd);
                }
            }
            

            if(cl.size() == 0){
                level++;
                System.out.println();
                Stack<Node>tmp = cl;
                cl = nl;
                nl = tmp;
            }
        }
    }

    public static boolean find(Node node, int data){
        if(node.data == data){
            return true;
        }

        for(Node child: node.children){
            boolean faith = find(child, data);
            if(faith){
                return true;
            } 
        }

        return false;
    }

    public static void main(String[] args) {
        // Write your code here
         Integer[] arr = {10,20,null,30,50,null,60,null,null,40,null,null};
         Node node = construct(arr);

         System.out.println("Level order");
         levelOrder(node);

         System.out.println();

         System.out.println("Level order linewise");
         levelOrderLinewise(node);

         System.out.println();

         System.out.println("Level order Zigzag");
         levelOrderZigZag(node);

         System.out.println();

         System.out.println("Find");
         System.out.println(find(node, 80));

    }
}
