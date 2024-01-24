// FLOYD WARSHAL ALGORITHM APPLICATION , GOOD PROBLEM

class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        int[][] dis = new int[n+1][n+1];
        
        for(int i=1;i<=n;i++){
            Arrays.fill(dis[i], Integer.MAX_VALUE);
            
            dis[i][i] = 0;
            if(i<n){
                dis[i][i+1] = 1;
            }
            if(i>1){
                dis[i][i-1] = 1;
            }
        }
        
        dis[x][y] = dis[y][x] = 1;
        
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(dis[i][k] != Integer.MAX_VALUE && dis[k][j]!=Integer.MAX_VALUE){
                        dis[i][j] = Math.min(dis[i][j], dis[i][k]+dis[k][j]);
                    }
                }
            }
        }
        
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(dis[i][j] != Integer.MAX_VALUE && i!=j){
                    mp.put(dis[i][j], mp.getOrDefault(dis[i][j],0) + 1);                
                }
            }
        }
        
        int[] ans = new int[n];
        for(int i=1;i<=n;i++){
            ans[i-1] = mp.getOrDefault(i, 0);
        }
        return ans;
    }
}
