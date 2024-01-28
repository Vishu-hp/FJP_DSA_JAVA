// NORMAL LOGIC PROBLEM , DECENT

class Solution {
    public int minimumCost(int[] nums) {
        int sm=Integer.MAX_VALUE, ssm = Integer.MAX_VALUE;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<sm){
                ssm = sm;
                sm = nums[i];
            }
            else if(nums[i]>=sm && nums[i]<ssm){
                ssm = nums[i];
            }
        }
        return nums[0] + sm + ssm;
    }
}
