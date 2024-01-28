// CONTSTRAINTS MADE IT EASY, FIND A BETTER SOLUTION IF THERE

class Solution {
    public int countBits(int num){
        int cnt=0;
        while(num > 0){
            num = num&(num-1);
            cnt++;
        }
        return cnt;
    }
    
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        boolean flg = true;
        for(int i=0;i<n-1;i++){
            if(nums[i] > nums[i+1]){
                flg = false;
                break;
            }
        }
        if(flg){
            return true;
        }
        
        int[] hlp = new int[n];
        for(int i=0;i<n;i++){
            int bts = countBits(nums[i]);
            hlp[i] = bts;
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n-1;j++){
                if(nums[j]>nums[j+1] && hlp[j]==hlp[j+1]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
        
        for(int i=0;i<n-1;i++){
            if(nums[i] > nums[i+1]){
                return false;
            }
        }
        return true;
    }
}
