class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int ans=0;
        
        int[][] xRows = new int[rows][cols];
        int[][] yRows = new int[rows][cols];

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                int v1 = (r>0)?xRows[r-1][c]:0;
                int v2 = (c>0)?xRows[r][c-1]:0;
                int v3 = (r>0 && c>0)?xRows[r-1][c-1]:0;
                int v4 = (grid[r][c] == 'X'?1: 0);

                int u1 = (r>0)?yRows[r-1][c]:0;
                int u2 = (c>0)?yRows[r][c-1]:0;
                int u3 = (r>0 && c>0)?yRows[r-1][c-1]:0;
                int u4 = (grid[r][c] == 'Y'?1: 0);
                xRows[r][c] = v1+v2-v3+v4 ;
                yRows[r][c] = u1+u2-u3+u4;

                if(xRows[r][c] == yRows[r][c] && xRows[r][c]>=1){
                    ans++;
                }
            }
        }
        
        return ans;
    }
}
