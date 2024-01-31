// https://leetcode.com/problems/restore-ip-addresses/

class Solution {
    public boolean isValid(String s){
        if(s.charAt(0) == '0'){
            return false;
        }

        int val = Integer.parseInt(s);
        return (val<=255);
    }

    public void solve(String s, int idx,int parts , String asf,List<String> ans){
        if(parts == 4 || idx>=s.length()){
            if(parts==4 && idx==s.length()){
                ans.add(asf.substring(0, asf.length()-1));
            }
            return;
        }

        solve(s, idx+1, parts+1, asf+s.charAt(idx)+".", ans);
        if(idx+2<=s.length() && isValid(s.substring(idx,idx+2))){
            solve(s, idx+2, parts+1, asf+s.substring(idx,idx+2)+".", ans);
        }
        if(idx+3<=s.length() && isValid(s.substring(idx,idx+3))){
            solve(s, idx+3, parts+1, asf+s.substring(idx,idx+3)+".", ans);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        solve(s, 0,0, "",ans);
        return ans;
    }
}
