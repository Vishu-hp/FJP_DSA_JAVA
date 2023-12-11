import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // String s1 = "hello";
        // String s2 = scn.nextLine();

        // System.out.println(s1);  
        // System.out.println(s2);  

        // System.out.println(s1.length());
        // System.out.println(s2.length());

        // System.out.println(s2.charAt(5));

        // String s3 = "abcd";

        // System.out.println(s3.substring(1,3));
        // System.out.println(s3.substring(1));

        // All Substrings
        // for(int i=0; i< s3.length();i++){
        //     for(int j=i+1; j<= s3.length(); j++){
        //         System.out.println(s3.substring(i,j));
        //     }
        // }

        // Adding to strings
        // String s1 = "hello";
        // String s2 = "world";
        // String s3 = s1 + " " + s2;
        // System.out.println(s3);

        // s1 += " ";
        // s1 += "w";
        // s1 += "o";
        // s1 += "r";
        // s1 += 10;
        // System.out.println(s1);

        // System.out.println("hello" + 10 + 20); // hello1020 - as it goes left to right
    
        // Split
        String s = "abc,def,ghi,jkl mno";
        String[] parts = s.split(",");
        for(int i=0; i<parts.length; i++){
            System.out.println(parts[i]);
        }
    }
}
