// Online Java Compiler
// Use this editor to write, compile and run your Java code online
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

    public static void levelOrder(Node node){
        // USING 2 QUEUES
            Queue<Node>cl = new ArrayDeque<>();
            Queue<Node>nl = new ArrayDeque<>();

            cl.add(node);
            while(cl.size() > 0){
                Node rem = cl.remove();
                
                System.out.print(rem.data + " ");

                if(rem.left != null) nl.add(rem.left);
                if(rem.right != null) nl.add(rem.right);

                if(cl.size() == 0){
                    System.out.println();
                    cl = nl;
                    nl = new ArrayDeque<>();
                }
            }

        // Using 1 queue
        Queue<Node>que = new ArrayDeque<>();
        que.add(node);

        while(que.size() > 0){
            int n = que.size();
            for(int i=0; i<n; i++){
                Node rem = que.remove();

                System.out.print(rem.data + " ");

                if(rem.left != null) que.add(rem.left);
                if(rem.right != null) que.add(rem.right);
            }
            System.out.println();
        } 
    }

    public static void preorder(Node node){
        if(node == null){
            return;
        }

        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

     public static void inorder(Node node){
        if(node == null){
            return;
        }

        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

     public static void postorder(Node node){
        if(node == null){
            return;
        }

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    public static boolean find(Node node, int data){
        if(node == null){
            return false;
        }

        if(node.data == data){
            return true;
        }

        boolean lf = find(node.left, data);
        if(lf){
            return true;
        }

        boolean rf = find(node.right, data);
        if(rf){
            return true;
        }

        return false;
    }

    static ArrayList<Integer>path;
    public static boolean nodeToRootPath(Node node, int data){
        if(node == null){
            return false;
        }

        if(node.data == data){
            path.add(node.data);
            return true;
        }

        boolean lf = nodeToRootPath(node.left, data);
        if(lf){
            path.add(node.data);
            return true;
        }

        boolean rf = nodeToRootPath(node.right, data);
        if(rf){
            path.add(node.data);
            return true;
        }

        return false;
    }

    // RECURSION
    public static void printKLevelDownRec(Node node, int k){
        if(node == null || k<0){
            return;
        }

        if(k == 0){
            System.out.print(node.data + " ");
        }

        printKLevelDownRec(node.left, k-1);
        printKLevelDownRec(node.right, k-1);
    }

    // USING LEVEL ORDER TRAVERSAL
     public static void printKLevelDownLo(Node node, int k){
        Queue<Node>cl = new ArrayDeque<>();
        Queue<Node>nl = new ArrayDeque<>();
        
        cl.add(node);
        while(cl.size() > 0){
            Node rem = cl.remove();

            if(rem.left != null) nl.add(rem.left);
            if(rem.right != null) nl.add(rem.right);

            if(cl.size() == 0){
                k--;
                cl = nl;
                nl = new ArrayDeque<>();
                if(k == 0){
                    break;
                }
            }
        }

        while(cl.size() > 0){
            Node rem = cl.remove();
            System.out.print(rem.data + " ");
        }
        System.out.println();
    }


    // USING PARENT NODE
    public static void printSingleChildPar(Node node,Node parent){
        if(node == null){
            return;
        }

        if(parent != null){
            if(parent.left==null && parent.right!=null){
                System.out.print(node.data + " ");
            }
            else if(parent.left!=null && parent.right==null){
                System.out.print(node.data + " ");
            }
        }

        printSingleChildPar(node.left, node);
        printSingleChildPar(node.right, node);
    }

    // WITHOUT PARENT NODE
    public static void printSingleChildWP(Node node){
        if(node == null){
            return;
        }

        
        if(node.left==null && node.right!=null){
            System.out.print(node.right.data + " ");
        }
        else if(node.left!=null && node.right==null){
            System.out.print(node.left.data + " ");
        }
        

        printSingleChildWP(node.left);
        printSingleChildWP(node.right);
    }


    public static void main(String[] args) {
        Integer arr[] = {10,20,40,null,null,50,70,null,null,null,30,null,60,null,null};
        Node root = construct(arr);
        
        levelOrder(root);

        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
        System.out.println();

        System.out.println(find(root, 80));
        
        path = new ArrayList<>();
        boolean ntrp = nodeToRootPath(root, 70);
        System.out.println(path);

        printKLevelDownRec(root, 2);
        System.out.println();
        printKLevelDownLo(root, 2);
        System.out.println();

        printSingleChildPar(root, null);
        System.out.println();
        printSingleChildWP(root);
        System.out.println();
    }
}
