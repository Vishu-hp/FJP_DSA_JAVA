// prefix sum concept for matrix used 

class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int r= mat.length, c = mat[0].length;
        // int[][] psum = new int[r][c];
        int[][] ans = new int[r][c];

        for(int i=0;i<r;i++){
            // int pfxsum=0;
            for(int j=1;j<c;j++){
                // pfxsum += mat[i][j];
                // psum[i][j] = pfxsum;
                mat[i][j] += mat[i][j-1];
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                ans[i][j] = 0;
                for(int x = Math.max(0,i-k);x<=Math.min(r-1, i+k);x++){
                    int mxj = Math.min(c-1, j+k);
                    int mnj = Math.max(0, j-k);
                    if(mnj == 0){
                        ans[i][j] += mat[x][mxj];  
                    }
                    else{
                        ans[i][j] += mat[x][mxj] - mat[x][mnj-1];
                    }
                }
            }
        }

        return ans;
    }
}
