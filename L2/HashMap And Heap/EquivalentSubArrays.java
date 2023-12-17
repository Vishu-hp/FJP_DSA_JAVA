class Solution
{ 
    // Method to calculate distinct sub-array 
    static int countDistinctSubarray(int arr[], int n) 
    { 
        HashMap<Integer, Integer>mp = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            mp.put(arr[i], mp.getOrDefault(arr[i],0) + 1);
        }
        
        int dis = mp.size();
        mp.clear();
        int ans=0;
        int j=0;
        for(int i=0;i<arr.length;i++){
            while(j<arr.length && mp.size()<dis){
                mp.put(arr[j], mp.getOrDefault(arr[j],0)+1);
                j++;
            }
            
            if(mp.size() == dis){
                ans += (arr.length-j+1);
            }
            
            mp.put(arr[i],mp.get(arr[i])-1);
            
            if(mp.get(arr[i]) == 0){
                mp.remove(arr[i]);
            }
        }
        return ans;
    }
}
