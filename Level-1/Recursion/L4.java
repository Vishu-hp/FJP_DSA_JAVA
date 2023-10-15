package recursion;

import java.util.ArrayList;

public class L4 {
    public static void main(String[] args) {
        String str = "abc";

        ArrayList<String> ans1 = gss(str);
        System.out.println(ans1);

        ArrayList<String> ans2 = getStairPaths(3);
        System.out.println(ans2);

        ArrayList<String>ans3 = getMazePaths(0,0,2,2);
        System.out.println(ans3);
    }

    public static ArrayList<String> gss(String str){
        if(str.length() == 0){
            ArrayList<String> sa = new ArrayList<>();
            sa.add("");
            return sa;
        }

        char firstChar = str.charAt(0);
        String ros = str.substring(1);
        ArrayList<String> faith = gss(ros);

        ArrayList<String> ans = new ArrayList<>();

        for(String s: faith){
            ans.add(s);
        }

        for(String s: faith){
            ans.add(firstChar + s);
        }

        return ans;
    }


    public static ArrayList<String> getStairPaths(int n){
        if(n == 0){
           ArrayList<String>al = new ArrayList<>();
           al.add("");
           return al;
        }

        if(n < 0){
            ArrayList<String>al = new ArrayList<>();
            return al;
        }

        ArrayList<String>f1 = getStairPaths(n-1);
        ArrayList<String>f2 = getStairPaths(n-2);
        ArrayList<String>f3 = getStairPaths(n-3);

        ArrayList<String>ans = new ArrayList<>();

        for(String s:f1){
            ans.add(s+"1");
        }

        for(String s:f2){
            ans.add(s + "2");
        }

        for(String s:f3){
            ans.add(s + "3");
        }

        return ans;
    }

    public static ArrayList<String> getMazePaths(int x,int y,int m,int n){
        if(x == m && y==n){
            ArrayList<String>sa = new ArrayList<>();
            sa.add("");
            return sa;
        }

        if(x>m || y>n){
            ArrayList<String>sa = new ArrayList<>();
            return sa;
        }

        ArrayList<String>f1 = getMazePaths(x, y+1,m,n);
        ArrayList<String>f2 = getMazePaths(x+1, y,m,n);

        ArrayList<String>ans = new ArrayList<>();

        for(String s:f1){
            ans.add("h"+s);
        }

        for(String s:f2){
            ans.add("v"+s);
        }

        return ans;
    }
}
