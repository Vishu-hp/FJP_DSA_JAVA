// https://www.geeksforgeeks.org/problems/coin-change2448/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

class Solution {
    public long count(int coins[], int N, int sum) {
        // code here.
       long[] dp = new long[sum+1];
       
       dp[0] = 1;
       
       for(int i=0; i<N;i++){
           for(int j = coins[i]; j<=sum;j++){
               dp[j] += dp[j - coins[i]];
           }
       }
       return dp[sum];
    }
}
