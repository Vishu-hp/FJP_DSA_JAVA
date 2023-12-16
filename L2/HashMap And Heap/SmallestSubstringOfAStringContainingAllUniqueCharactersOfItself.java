class Solution {
    public int findSubString( String str) {
        // Your code goes here
        HashSet<Character>hst = new HashSet<>();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            hst.add(c);
        }
        
        int ans=Integer.MAX_VALUE;
        
        HashMap<Character,Integer>mp = new HashMap<>();
        int i=0, j=0;
        while(j<str.length()){
            char c = str.charAt(j);
            mp.put(c, mp.getOrDefault(c, 0)+1);
            
            if(mp.size() == hst.size()){
                ans = Math.min(ans, j-i+1);
                while(i<=j && mp.size() == hst.size()){
                    ans = Math.min(ans, j-i+1);
                    int fr = mp.get(str.charAt(i));
                    if(fr == 1){
                        mp.remove(str.charAt(i));
                    }
                    else{
                        mp.put(str.charAt(i), fr-1);
                    }
                    i++;
                }
            }
            j++;
        }
        return ans;
    }
}
