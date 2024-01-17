// https://leetcode.com/problems/path-with-maximum-gold/

class Solution {
    public int solve(int[][] grid, int r,int c){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]==0){
            return 0;
        }

        int tmp = grid[r][c];
        grid[r][c] = 0;

        int ans = 0;
        ans = Math.max(ans, tmp + solve(grid,r+1,c));
        ans = Math.max(ans, tmp + solve(grid,r-1,c));
        ans = Math.max(ans, tmp + solve(grid,r,c+1));
        ans = Math.max(ans, tmp + solve(grid,r,c-1));

        grid[r][c] = tmp;
        return ans;
    }

    public int getMaximumGold(int[][] grid) {
        int ans=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] != 0){
                    ans = Math.max(ans, solve(grid,i,j));
                }
            }
        }

        return ans;
    }
}
