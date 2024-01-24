// GREAT PROBLE ON IMPLEMENTATION , RESOLVE IT TO GAIN MORE UNDERSTANDING

class Solution {
    public int minimumPushes(String word) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for(char c: word.toCharArray()){
            mp.put(c, mp.getOrDefault(c,0) + 1);
        }
        
        ArrayList<Integer> lst = new ArrayList<>(mp.values());
        Collections.sort(lst, Collections.reverseOrder());
        
        int ans=0, lev=1;
        for(int i=0;i<lst.size();i++){
            if(i>7 && i%8==0){
                lev++;
            }
            
            ans += lev*lst.get(i);
        }
        return ans;
    }
}
