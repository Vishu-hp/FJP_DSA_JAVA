// https://www.geeksforgeeks.org/problems/largest-number-in-k-swaps-1587115620/1

class Solution
{
    //Function to find the largest number after k swaps.
    public static String ans="";
     
    public static void solve(char[] str, int k){
       if(k==0){
           return;
       }
       
       for(int i=0;i<str.length-1;i++){
           for(int j=i+1;j<str.length;j++){
               if(str[j] > str[i]){
                   char tmp = str[i];
                   str[i] = str[j];
                   str[j] = tmp;
                   
                   String newS = new String(str);
                   
                   if(ans.compareTo(newS) < 0){
                       ans = newS;
                   }
                   
                   solve(str,k-1);
                   
                   tmp = str[i];
                   str[i] = str[j];
                   str[j] = tmp;
               }
           }
       }
    }
    
    public static String findMaximumNum(String str, int k)
        {
            //code here.
            ans = str;
            solve(str.toCharArray(),k);
            return ans;
        }
}
