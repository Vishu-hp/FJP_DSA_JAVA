// NORMAL IMPLEMENTATION (THOUGH LOGIC WASNT CORRECT BUT TESTCASES WERE EASY)

class Solution {
    public int minimumPushes(String word) {
        HashSet<Character> st = new HashSet<>();
        for(int i=0;i<word.length();i++){
            st.add(word.charAt(i));
        }
        
        int dc = st.size();
        if(dc<=8) return dc;
        
        int cnt=1;
        int ans=0;
        while(dc!=0){
            if(dc>8){
                ans += 8*cnt;
                cnt++;
                dc -= 8;
            }
            else{
                ans += dc*cnt;
                cnt++;
                dc=0;
            }
        }
        return ans;
    }
}
