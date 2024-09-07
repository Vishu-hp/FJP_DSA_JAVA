// Used prefix sum concept directly

class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] pfxSum = new int[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(j==0){
                    pfxSum[i][j] = matrix[i][j];
                    continue;
                }

                pfxSum[i][j] = pfxSum[i][j-1] + matrix[i][j];
            }
        }

        for(int i=0;i<cols;i++){
            for(int j=0;j<rows;j++){
                if(j==0){
                    continue;
                }

                pfxSum[j][i] += pfxSum[j-1][i];
            }
        }

        int ans=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                for(int x=i;x<rows;x++){
                    for(int y=j;y<cols;y++){
                        int val = pfxSum[x][y];

                        if(i>0){
                            val -= pfxSum[i-1][y];
                        }

                        if(j>0){
                            val -= pfxSum[x][j-1];
                        }

                        if(i>0 && j>0){
                            val += pfxSum[i-1][j-1];
                        }

                        if(val == target){
                            ans++;
                        }
                    }
                }
            }
        }

        return ans;
    }
}


// Further optimization in above solution - (not clearly understood it)
class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] pfxSum = new int[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(j==0){
                    pfxSum[i][j] = matrix[i][j];
                    continue;
                }

                pfxSum[i][j] = pfxSum[i][j-1] + matrix[i][j];
            }
        }

        int ans=0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int s=0;s<cols;s++){
            for(int e=s;e<cols;e++){
                int sum = 0;
                mp.clear();
                mp.put(0,1);
                for(int r=0; r<rows; r++){
                    sum += pfxSum[r][e] - (s>0 ? pfxSum[r][s-1] : 0);
                    ans += mp.getOrDefault(sum-target, 0);
                    mp.put(sum, mp.getOrDefault(sum,0) + 1);
                }
            }
        }

        return ans;
    }
}
