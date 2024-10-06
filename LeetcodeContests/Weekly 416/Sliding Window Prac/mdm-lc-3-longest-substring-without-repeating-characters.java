// sliding window direct implementation

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        HashMap<Character, Integer> arr = new HashMap<>();
        int start = 0, ans=0;

        for(int ci=0; ci< s.length(); ci++){
            arr.put(s.charAt(ci), arr.getOrDefault(s.charAt(ci), 0) + 1);

            while(arr.get(s.charAt(ci)) > 1){
                arr.put(s.charAt(start), arr.get(s.charAt(start))-1);
                start++;
            }

            ans = Math.max(ans, ci-start+1);
        }        
        return ans;
    }
}
