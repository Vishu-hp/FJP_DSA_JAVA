package recursion;

import java.util.Scanner;

public class L3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        displayArray(arr, 0);
        displayArrayReverse1(arr, 0);
        displayArrayReverse2(arr, arr.length - 1);

        System.out.println(maxOfArray(arr, 0));

        int [] ans = allIndexes(arr, 0, 7, 0);
        for(int x:ans){
            System.out.println(x);
        }
    }

    public static void displayArray(int [] arr, int idx){
        if(idx == arr.length){
            return;
        }

        System.out.println(arr[idx]);
        displayArray(arr, idx+1);
    }

//    displayArrReverse1(arr, 0)
    public static void displayArrayReverse1(int [] arr, int idx){
        if(idx == arr.length) return;

        displayArrayReverse1(arr, idx+1);
        System.out.println(arr[idx]);
    }

    //    displayArrReverse2(arr, arr.length - 1)
    public static void displayArrayReverse2(int [] arr, int idx){
        if(idx == -1) return;

        System.out.println(arr[idx]);
        displayArrayReverse2(arr, idx-1);
    }


    public static int maxOfArray(int [] arr, int idx){
        if(idx == arr.length) return Integer.MIN_VALUE;

        int faith = maxOfArray(arr, idx+1);
        if(arr[idx] > faith){
            return arr[idx];
        }

        return faith;
    }

    public static int firstIndex(int [] arr, int idx, int x){
        if(idx == arr.length){
            return -1;
        }

        int faith = firstIndex(arr, idx+1, x);
        if(arr[idx] == x){
            return idx;
        }
        return faith;
    }

    public static int lastIndex(int [] arr, int idx, int x){
        if(idx == arr.length){
            return -1;
        }

       int faith = lastIndex(arr, idx+1, x);
        if(faith != -1){
            return faith;
        }

        if(arr[idx] == x){
            return idx;
        }

        return -1;
    }

    public static int [] allIndexes(int [] arr, int idx, int x, int fsf){
        if(idx == arr.length){
            int [] ret = new int[fsf];
            return ret;
        }

        if(arr[idx] == x){
            int [] rarr = allIndexes(arr, idx+1, x, fsf+1);
            rarr[fsf] = idx;
            return rarr;
        }
        else{
            int [] rarr = allIndexes(arr, idx+1, x, fsf);
            return rarr;
        }
    }
}
