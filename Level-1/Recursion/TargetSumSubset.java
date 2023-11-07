package recursion;

import java.util.Scanner;

public class TargetSumSubset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int tar = sc.nextInt();

        printTargetSumSubset(arr, 0, "", 0, tar);
    }

    public static void printTargetSumSubset(int[] arr, int idx, String asf, int sum, int tar){
        if(idx == arr.length){
            if(sum == tar){
                System.out.println(asf+".");
            }
            return;
        }

        printTargetSumSubset(arr, idx+1, asf+arr[idx], sum+arr[idx], tar);
        printTargetSumSubset(arr, idx+1, asf, sum, tar);
    }
}
