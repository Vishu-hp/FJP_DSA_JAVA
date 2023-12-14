class Solution{
    int longSubarrWthSumDivByK(int a[], int n, int k)
    {
        // Complete the function
       HashMap<Integer,Integer>mp = new HashMap<>();
       int ps = 0;
       int ans = 0;
       for(int i=0;i<a.length;i++){
           int val = a[i];
           ps += val;
           int rem = ps%k;
           
           if(rem<0){
               rem += k;
           }
           
           if(rem == 0){
               ans = Math.max(ans, i+1);
               continue;
           }
           
           if(mp.containsKey(rem)){
               ans = Math.max(ans, i-mp.get(rem));
           }
           else{
               mp.put(rem,i);
           }
       }
       return ans;
    }
 
}
