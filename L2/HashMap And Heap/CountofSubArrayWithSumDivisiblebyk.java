// https://leetcode.com/problems/subarray-sums-divisible-by-k/

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer>mp = new HashMap<>();
        mp.put(0, 1);

        int psum=0;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            psum += nums[i];
            int rem = psum%k;
            if(rem<0){
                rem += k;
            }

            if(mp.containsKey(rem)){
                ans += mp.get(rem);
            }

            mp.put(rem, mp.getOrDefault(rem, 0) + 1);
        }

        return ans;
    }
}
