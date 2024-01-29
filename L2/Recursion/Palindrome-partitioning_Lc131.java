// https://leetcode.com/problems/palindrome-partitioning/

class Solution {
    public boolean isPalindrome(String str){
        int s=0, e=str.length()-1;
        while(s<=e){
            if(str.charAt(s) != str.charAt(e)){
                return false;
            }
            s++;
            e--;
        }
        return true;
    }

    public void solve(String s, int idx, List<String> hlp, List<List<String>> ans){
        if(idx == s.length()){
            ans.add(new ArrayList<>(hlp));
            return;
        }

        for(int i=idx;i<s.length();i++){
            if(isPalindrome(s.substring(idx, i+1))){
                hlp.add(s.substring(idx, i+1));
                solve(s, i+1, hlp, ans);
                hlp.remove(hlp.size()-1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> hlp = new ArrayList<>();
        solve(s, 0, hlp , ans);

        return ans;
    }
}
