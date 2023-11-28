
import java.io.*;
import java.util.*;

class Main {
    public static class Node{
        int data;
        Node left, right;

        Node(int data, Node left, Node right){
            this.data= data;
            this.left= left;
            this.right = right;
        }
    }

    public static Node construct(int[] arr, int lo, int hi){
       if(lo > hi){
           return null;
       }

       int mid = (lo + hi)/2;

       int data = arr[mid];
       Node lc = construct(arr, lo, mid-1);
       Node rc = construct(arr, mid+1, hi);

       Node node = new Node(data, lc, rc);
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

    public static int max(Node node){
        while(node.right != null){
            node = node.right;
        }

        return node.data;
    } 

    public static int min(Node node){
         while(node.left != null){
            node = node.left;
        }

        return node.data;
    } 


    public static Node add(Node node, int data){
        if(node == null){
            return new Node(data, null, null);
        }

        if(data > node.data){
            node.right = add(node.right, data);
        }
        else if(data < node.data){
            node.left = add(node.left, data);
        }
        else{
            // do nothing
        }

        return node;
    }

     public static Node remove(Node node, int data){
        if(node == null){
            return null;
        }

        if(data > node.data){
            node.right = remove(node.right, data);
        }
        else if(data < node.data){
            node.left = remove(node.left, data);
        }
        else{
            if(node.left == null && node.right==null){
                return null;
            }
            else if(node.left == null && node.right!=null){
                return node.right;
            }
             else if(node.right == null && node.left!=null){
                return node.left;
            }
            else{
                int maxVal = max(node.left);
                node.data = maxVal;
                node.left = remove(node.left, maxVal);
                return node;
            }
        }
        return node;
    }

    public static int lca(Node node, int d1, int d2){

        if(node.data > d1 && node.data > d2){
            return lca(node.left, d1, d2);
        }
        else if(node.data < d1 && node.data < d2){
            return lca(node.right, d1, d2);
        }
        else{
            return node.data;
        }
    }


    static int sum = 0;
    public static void rwsol(Node node){
        if(node == null){
            return;
        }

        rwsol(node.right);
        int val = node.data;
        node.data = sum;
        sum += val;
        rwsol(node.left);
    }



    public static void main(String[] args) {
        int[] arr = {12, 25, 37, 50, 62, 75, 87};
        Node root = construct(arr, 0, arr.length - 1);
        // display(root);

        // int size = size(root);
        // int sum = sum(root);
        // int max = max(root);
        // int min = min(root);

        // System.out.println("Size: " + size);
        // System.out.println("Sum: " + sum);
        // System.out.println("Max: " + max);
        // System.out.println("Min: " + min);

        // display(root);
        // System.out.println();
        // add(root, 60);
        // display(root);

        // add(root, 60);
        // display(root);
        // System.out.println();
        // remove(root, 60);
        // display(root);

        // System.out.println(lca(root, 62, 75));

        // display(root);
        // System.out.println();
        // rwsol(root);
        // display(root);
    }
}
