// https://www.geeksforgeeks.org/problems/coin-change2448/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

class Solution {
    public long solve(int[] coins, int n, int sum, int idx, int ssf, long[][] memo){
        if(ssf> sum){
            return 0;
        }
        
        if(idx == n){
            if(ssf == sum){
                return 1;
            }
            return 0;
        }
        
        if(memo[idx][ssf] != -1){
            return memo[idx][ssf];
        }
        
        return memo[idx][ssf] = solve(coins,n,sum,idx,ssf+coins[idx],memo) + 
               solve(coins,n,sum,idx+1,ssf,memo);
    }
    
    public long count(int coins[], int N, int sum) {
        // code here.
        long[][] memo = new long[N+1][sum+1];
         for(int i = 0 ; i <=N ; i++){
            for(int j=0; j<=sum;j++){
                memo[i][j] = -1;
            } 
         }
            
        long ans = solve(coins,N,sum, 0, 0, memo);
        return ans;
    }
}
