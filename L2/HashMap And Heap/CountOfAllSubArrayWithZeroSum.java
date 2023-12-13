class Solution{
    //Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] arr ,int n) 
    {
        //Your code here
        int ans = 0;
        
        HashMap<Integer, Integer>mp = new HashMap<>();  
        int psum = 0;
        mp.put(0, 1);
        
        for(long val: arr){
            psum += val;
            
            if(mp.containsKey(psum)){
                int vl = mp.get(psum);
                ans += vl;
                
            }
           mp.put(psum, mp.getOrDefault(psum,0)+1);
        }
        return ans;
        
    }
}
