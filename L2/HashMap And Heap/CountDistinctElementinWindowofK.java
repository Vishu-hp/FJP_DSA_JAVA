class Solution
{
    ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        // code here 
        ArrayList<Integer>ans = new ArrayList<>();
        HashMap<Integer, Integer>mp = new HashMap<>();
        
        for(int i=0;i<k;i++){
            mp.put(A[i], mp.getOrDefault(A[i], 0) + 1);
        }
        
        ans.add(mp.size());
        
        for(int i=k; i<A.length; i++){
            mp.put(A[i], mp.getOrDefault(A[i],0)+1);
            
            int j= i-k;
            int frq = mp.get(A[j]);
            if(frq == 1){
                mp.remove(A[j]);
            }
            else{
                mp.put(A[j], frq-1);
            }
            
            ans.add(mp.size());
        }
        return ans;
    }
}
