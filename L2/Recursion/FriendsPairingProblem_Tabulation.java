// https://www.geeksforgeeks.org/problems/friends-pairing-problem5425/1

class Solution
{
    public long countFriendsPairings(int n) 
    { 
       //code here
       long[] dp = new long[n+1];
       int mod = (int)1e9+7;
       
       for(int i=0;i<=n;i++){
           if(i<=2){
               dp[i] = i;
               continue;
           }
           dp[i] = (dp[i-1] + ((i-1) * dp[i-2])%mod)%mod;
       }
       
       return dp[n];
    }
}    
