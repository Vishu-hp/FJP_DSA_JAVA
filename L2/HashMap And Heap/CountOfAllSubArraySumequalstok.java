// https://leetcode.com/problems/subarray-sum-equals-k/

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer>mp = new HashMap<>();
        mp.put(0, 1);
        int psum=0, ans=0;

        for(int i=0; i<nums.length; i++){
            psum += nums[i];

            if(mp.containsKey(psum-k)){
                ans += mp.get(psum-k);
            }

            mp.put(psum, mp.getOrDefault(psum, 0) + 1);
        }
        return ans;
    }
}
