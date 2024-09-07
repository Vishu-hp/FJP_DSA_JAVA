// prefix sum in matrices concept used purely

class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(j!=0){
                    matrix[i][j] ^= matrix[i][j-1];
                }
            }
        }

        for(int j=0;j<matrix[0].length;j++){
            for(int i=0;i<matrix.length;i++){
                if(i!=0){
                    matrix[i][j] ^= matrix[i-1][j];
                }
                pq.add(matrix[i][j]);
            }
        }

        for(int i=0;i<k-1;i++){
            pq.poll();
        }

        int ans = pq.poll();
        return ans;
    }
}
