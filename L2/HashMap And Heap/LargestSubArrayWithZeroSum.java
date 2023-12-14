class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        HashMap<Integer, Integer>mp = new HashMap<>();
        int ps = 0;
        int ans=0;
        
        mp.put(0,-1);
        for(int i=0; i<arr.length; i++){
            int val = arr[i];
            ps += val;
            
            if(mp.containsKey(ps)){
                ans = Math.max(ans, i-mp.get(ps));
            }
            else{
                mp.put(ps, i);
            }
        }
        return ans;
    }
}
