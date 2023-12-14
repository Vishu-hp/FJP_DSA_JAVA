class Solution
{
    //Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
        // add your code here
        HashMap<Integer,Integer>mp = new HashMap<>();
        int no=0,n1=0;
        int ans=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                no++;
            }
            else{
                n1++;
            }
            
            int d = no-n1;
            
            if(d==0){
                ans = ans+1;   
            }
            
            if(mp.containsKey(d)){
                ans += mp.get(d);
                int vl = mp.get(d);
                mp.put(d, vl+1);
            }
            else{
                mp.put(d,1);
            }
         }
        return ans;
    }
}
