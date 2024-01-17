// https://www.geeksforgeeks.org/problems/coin-change2448/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

class Solution {
    public long count(int coins[], int N, int sum) {
        // code here.
        long[][] dp = new long[N+1][sum+1];
        
        dp[0][0] = 1;
        
        for(int i=1;i<=N;i++){
            for(int j=0;j<=sum;j++){
                dp[i][j] += dp[i-1][j];
                
                if(j - coins[i-1] >= 0){
                    dp[i][j] += dp[i][j - coins[i-1]];
                }
            }
        }
        
        return dp[N][sum];
    }
}
