// read the problem wrong, always read problem twice, though problem logic is good

class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long maxSum = Long.MIN_VALUE, sum = 0;
        HashMap<Integer, Long> remMap = new HashMap<Integer, Long>();

        for(int i=0; i<n; i++){
            sum += nums[i];

            if((i+1)%k == 0){
                maxSum = Math.max(maxSum, sum);
            }

            int rem = (i+1)%k;
            if(remMap.containsKey(rem)){
                maxSum = Math.max(maxSum, sum - remMap.get(rem));
                remMap.put(rem, Math.min(remMap.get(rem), sum));
            }
            else{
                remMap.put(rem,sum);
            }
        }
       
       return maxSum;
    }
}
