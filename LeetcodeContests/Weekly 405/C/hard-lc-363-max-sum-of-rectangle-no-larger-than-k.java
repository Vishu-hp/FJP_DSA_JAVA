// used prefix sum in matrices in it
// can be further optimised also *****

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] pfxSum = new int[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                pfxSum[i][j] = matrix[i][j];
                if(j>0){
                    pfxSum[i][j] += pfxSum[i][j-1];
                }
            }
        }

         for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(i>0){
                    pfxSum[i][j] += pfxSum[i-1][j];
                }
            }
        }

        int ans= Integer.MIN_VALUE;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                for(int ei=i;ei<rows;ei++){
                    for(int ej=j;ej<cols;ej++){
                            int sum=pfxSum[ei][ej];

                            if(i>0 && j>0){
                                sum += pfxSum[i-1][j-1];
                            }

                            if(i>0){
                             sum -= pfxSum[i-1][ej];
                            }

                            if(j>0){
                                sum -= pfxSum[ei][j-1];
                            }

                            if(sum<=k && sum> ans){
                                ans = sum;
                            }
                    }
                }
            }
        }

        return ans;
    }
}
