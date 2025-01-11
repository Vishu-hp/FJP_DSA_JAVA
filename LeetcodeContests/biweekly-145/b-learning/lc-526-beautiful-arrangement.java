// good problem using recursion , can be further optimized as well

class Solution {
    public int solve(int num, int[] vis, int n){
        if(num > n){
            for(int i=0;i<n;i++){
                if(vis[i] == -1) return 0;
            }
            return 1;
        }

        int ans = 0;
        for(int i=0;i<n;i++){
            if(vis[i] == -1 && 
            (num%(i+1) == 0 || (i+1)%num == 0)){
                vis[i] = num;
                ans += solve(num+1, vis, n);
                vis[i] = -1;
            }
        }

        return ans;
    }

    public int countArrangement(int n) {
        int[] vis = new int[n];
        Arrays.fill(vis, -1);
        return solve(1, vis, n);
    }
}
