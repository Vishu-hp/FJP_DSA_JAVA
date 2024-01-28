// PROBABLY IMPOSSIBLE LOGIC TO THINK OF 

class Solution {
    public int minimumArrayLength(int[] nums) {
        int n = nums.length;
        int mv = nums[0];
        for(int i=0;i<n;i++){
            mv = Math.min(mv, nums[i]);
        }
        
        int cnt=0;
        for(int i=0;i<n;i++){
            if(nums[i] == mv){
                cnt++;
            }
        }
        
        if(cnt==1){
            return 1;
        }
        
        for(int i=0;i<n;i++){
            if(nums[i]%mv != 0){
                return 1;
            }
        }
        
        return (cnt+1)/2;
    }
}
