package recursion;

import java.util.Scanner;

public class KnightsTour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sr = sc.nextInt(), scol = sc.nextInt();

        int[][] arr = new int[n][n];
        knightTour(arr, sr, scol, 1);
    }

    public static void displaygrid(int[][] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void knightTour(int[][] arr, int sr, int sc, int cnt){
        if(sr<0 || sc<0 || sr>=arr.length || sc>=arr[0].length || arr[sr][sc]!=0){
            return;
        }

        if(cnt == arr.length*arr[0].length){
            arr[sr][sc] = arr.length * arr[0].length;
            displaygrid(arr);
            arr[sr][sc]=0;
            return;
        }

        arr[sr][sc] = cnt;
        knightTour(arr, sr-2,sc+1,cnt+1);
        knightTour(arr, sr-1,sc+2,cnt+1);
        knightTour(arr, sr+1,sc+2,cnt+1);
        knightTour(arr, sr+2,sc+1,cnt+1);
        knightTour(arr, sr+2,sc-1,cnt+1);
        knightTour(arr, sr+1,sc-2,cnt+1);
        knightTour(arr, sr-1,sc-2,cnt+1);
        knightTour(arr, sr-2,sc-1,cnt+1);
        arr[sr][sc]=0;
    }
}
