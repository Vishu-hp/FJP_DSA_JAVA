// GOOD RECURSION + MEMO PROBLEM

class Solution {
    int[] dp;
    public int solve(int x, int y){
        if(x<=y){
            return y-x;
        }
        
        if(dp[x] != -1){
            return dp[x];
        }
        
        int ans = x-y;
        
        ans = Math.min(ans, x%5 + solve(x/5, y) +1);
        ans = Math.min(ans, 5-x%5 + solve(x/5 +1, y) +1);
        ans = Math.min(ans, x%11 + solve(x/11, y) +1);
        ans = Math.min(ans, 11-x%11 + solve(x/11 +1, y) +1);
        
        return dp[x] = ans;
    }
    
    public int minimumOperationsToMakeEqual(int x, int y) {
        dp = new int[10005];
        Arrays.fill(dp, -1);
        return solve(x,y);
    }
}
