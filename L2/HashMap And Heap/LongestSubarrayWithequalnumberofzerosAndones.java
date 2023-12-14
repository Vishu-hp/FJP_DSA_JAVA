class Solution {

    // arr[] : the input array containing 0s and 1s
    // N : size of the input array
    
    // return the maximum length of the subarray
    // with equal 0s and 1s
    int maxLen(int[] arr, int N)
    {
        // Your code here
        HashMap<Integer, Integer>mp = new HashMap<>();
        int no=0,n1=0;
        int ans=0;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 1){
                n1++;
            }
            else{
                no++;
            }
            
            int d = no-n1;
            
            if(d==0){
                ans = Math.max(ans, i+1);
                continue;
            }
            
            if(mp.containsKey(d)){
                ans = Math.max(ans, i-mp.get(d));
            }
            else{
                mp.put(d, i);
            }
        }
        return ans;
    }
}
