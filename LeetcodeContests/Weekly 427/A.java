// direct implementation

class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for(int i=0; i<n; i++){
            if(nums[i] > 0) {
                int idx = (i+nums[i])%n;
                res[i] = nums[idx];
            }
            else if( nums[i] < 0 ){
                int idx = i - Math.abs(nums[i]);
                idx = idx%n;
                if(idx < 0){
                    idx += n;
                }
                res[i] = nums[idx];
            }
            else {
                res[i] = nums[i];
            }
        }

        return res;
    }
}
