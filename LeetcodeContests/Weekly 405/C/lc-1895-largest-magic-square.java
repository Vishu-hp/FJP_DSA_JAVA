// use of prefix sum concept in matrices 

class Solution {
    public int largestMagicSquare(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        int [][] pfxRows = new int[rows][cols]; 
        int [][] pfxCols = new int[rows][cols]; 

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){

                pfxRows[i][j] = grid[i][j] + (j>0? pfxRows[i][j-1] : 0);
                pfxCols[i][j] = grid[i][j] + (i>0? pfxCols[i-1][j] : 0);
            }
        }

        int ans=1;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                for(int k=Math.min(rows-i, cols-j);k>ans;k--){
                    boolean flag=true;

                    // rows
                    int rowSum = pfxRows[i][j+k-1] - pfxRows[i][j] + grid[i][j];
                    for(int z=0;z<k;z++){
                        if(rowSum != pfxRows[i+z][j+k-1]-pfxRows[i+z][j]+grid[i+z][j]){
                            flag=false;
                            break;
                        }
                    }

                    // cols
                    if(flag){
                        int colsum = pfxCols[i+k-1][j] - pfxCols[i][j] + grid[i][j];
                        for(int z=0;z<k;z++){
                            if(rowSum != colsum || colsum != pfxCols[i+k-1][j+z]-pfxCols[i][j+z]+grid[i][j+z]){
                                flag=false;
                                break;
                            }
                        }   
                    }

                    if(flag){
                        // diag
                        int diagSum = 0;
                        for(int z=0;z<k;z++){
                            diagSum += grid[i+z][j+z];
                        }

                        // diag 2
                        int diagSum2 = 0;
                        for(int z=0;z<k;z++){
                            diagSum2 += grid[i+z][j+k-1-z];
                        }

                        if(diagSum != diagSum2 || rowSum != diagSum){
                            flag=false;
                        }
                    }

                    if(flag){
                        ans = k;
                        break;
                    }

                }
            }
        }

        return ans;
    }
}
