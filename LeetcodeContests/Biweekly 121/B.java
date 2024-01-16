// BIT MANIPULATION, CHECKING FOR EVERY BIT

class Solution {
    public int minOperations(int[] nums, int k) {
        int ans=0;
        
        for(int i=0;i<=31;i++){
            int xor = 0;
            for(int j=0;j<nums.length;j++){
                if(((nums[j]>>i) & 1) == 1){
                    xor ^= 1;
                }
            }
            
            if(((k>>i)&1 ) != xor){
                ans++;
            }
        }
        return ans;
    }
}
