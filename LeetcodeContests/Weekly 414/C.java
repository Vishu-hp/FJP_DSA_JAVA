// used dp, but greedy wins here, sometimes being greedy is good

class Solution {
    public long findMaximumScore(List<Integer> nums) {
        int n = nums.size();
        long ans = 0;
        int li = 0;
        for(int i=1; i< n; i++){
            if(nums.get(i) > nums.get(li)){
                ans += (long)(i-li) * nums.get(li);
                li = i;
            }
        }

        System.out.println(li);
        return ans + (long)(n-1 - li) * nums.get(li);
    }
}
