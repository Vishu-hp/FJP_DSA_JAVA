// DIDNT READ PROBLEM PROPERLY

class Solution {
    public int missingInteger(int[] nums) {
        int psum=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]+1){
                psum += nums[i];
                continue;
            }
            break;
        }
        
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length;i++){
            if(psum == nums[i]){
                psum++;
            }
        }
        
        return psum;
    }
}
