// https://www.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string-1587115621/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
// https://leetcode.com/problems/minimum-window-substring/

class Solution {
    public String minWindow(String s, String t) {
         HashMap<Character, Integer>mp = new HashMap<>();
        
        for(char c: t.toCharArray()){
            mp.put(c, mp.getOrDefault(c,0) + 1);
        }
        
        int have=0, need=mp.size();
        int minLen = s.length()+1, si=0;
        int i=0;
        for(int j=0;j<s.length();j++){
            char c = s.charAt(j);
            
            if(mp.containsKey(c)){
                mp.put(c, mp.get(c)-1);
                
                if(mp.get(c) == 0){
                    have++;
                }
            }
            
            while(have == need){
                if(minLen > j-i+1){
                    minLen = j-i+1;
                    si= i; 
                }
                
                char c2 = s.charAt(i);
                if(mp.containsKey(c2)){
                    if(mp.get(c2) == 0){
                        have--;
                    }
                    mp.put(c2, mp.get(c2)+1);
                }
                
                i++;
            }
        }
        
        if(minLen > s.length()){
            return "";
        }
        
        return s.substring(si, si+minLen);
    }
}
