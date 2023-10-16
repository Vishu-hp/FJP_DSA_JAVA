package recursion;

import java.util.Scanner;
import java.util.ArrayList;
public class L5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        String str = sc.nextLine();

        ArrayList<String>ans = getMazePathsWithJumps(1,1,m,n);
        System.out.println(ans);

        pss(str, "");

        int steps = sc.nextInt();
        printStairPaths(steps, "");

        printMazePaths(1,1,m,n,"");

        printMazePathsWithJumps(1,1,m,n,"");

        printPermutation(str, "");
    }

    public static ArrayList<String> getMazePathsWithJumps(int sr,int sc,int dr,int dc){
        if(sr == dr && sc == dc){
            ArrayList<String>sa = new ArrayList<>();
            sa.add("");
            return  sa;
        }

        ArrayList<String>ans = new ArrayList<>();

//        horizontal moves
        for(int j=1; j<=dc-sc;j++){
            ArrayList<String>sa = getMazePathsWithJumps(sr,sc+j,dr,dc);

            for(String s:sa){
                ans.add("h"+j+s);
            }
        }

        //        vertical moves
        for(int j=1; j<=dr-sr;j++){
            ArrayList<String>sa = getMazePathsWithJumps(sr+j,sc,dr,dc);

            for(String s:sa){
                ans.add("v"+j+s);
            }
        }

        //        horizontal moves
        for(int j=1; j<=dc-sc && j<= dr-sr;j++){
            ArrayList<String>sa = getMazePathsWithJumps(sr+j,sc+j,dr,dc);

            for(String s:sa){
                ans.add("d"+j+s);
            }
        }

        return ans;
    }

    public static void pss(String str, String ssf){
        if(str.length() == 0){
            System.out.println(ssf);
            return;
        }

        char fc = str.charAt(0);
        String ros = str.substring(1);

        pss(ros, ssf+fc);
        pss(ros, ssf);
    }

    public static void printStairPaths(int n, String psf){
        if(n==0){
            System.out.println(psf);
            return;
        }

        if(n<0){
            return;
        }

        printStairPaths(n-1, psf+"1");
        printStairPaths(n-2, psf+"2");
        printStairPaths(n-3, psf+"3");
    }

    public static void printMazePaths(int sr,int sc,int dr,int dc,String psf){
        if(sr == dr && sc == dc){
            System.out.println(psf);
            return;
        }

        if(sr>dr || sc>dc){
            return;
        }

        printMazePaths(sr,sc+1,dr,dc,psf+"h");
        printMazePaths(sr+1,sc,dr,dc,psf+"v");
    }

    public static void printMazePathsWithJumps(int sr,int sc,int dr,int dc,String psf){
        if(sr==dr && sc==dc){
            System.out.println(psf);
            return;
        }

        for(int j=1;j<=dc-sc;j++){
            printMazePathsWithJumps(sr,sc+j,dr,dc,psf+"h"+j);
        }

        for(int j=1;j<=dr-sr;j++){
            printMazePathsWithJumps(sr+j,sc,dr,dc,psf+"v"+j);
        }

        for(int j=1;j<=dr-sr && j<=dc-sc;j++){
            printMazePathsWithJumps(sr+j,sc+j,dr,dc,psf+"d"+j);
        }
    }

    public static void printPermutation(String str,String asf){
        if(str.length() == 0){
            System.out.println(asf);
            return;
        }


        for(int i=0; i< str.length(); i++){
            char ch = str.charAt(i);
            String strl = str.substring(0,i);
            String strr = str.substring(i+1);
            String ros = strl + strr;
            printPermutation(ros, asf + ch);
        }
    }
}
