// https://www.geeksforgeeks.org/problems/friends-pairing-problem5425/1
// GIVES TLE IN THIS

class Solution
{
    long[] dp = new long[10001];
    int mod = (int)1e9+7;
    
    public long solve(int n){
       if (dp[n] != -1)
            return dp[n];
 
        if (n > 2)
            return dp[n] = (solve(n - 1) + ((n - 1) * solve(n - 2))%mod)%mod;
        else
            return dp[n] = n;
    }
    
    public long countFriendsPairings(int n) 
    { 
       //code here
       for(int i=0;i<=10000;i++){
           dp[i] = -1;
       }
       
       return solve(n);
    }
}    
