// https://leetcode.com/problems/remove-invalid-parentheses/description/

class Solution {
    public boolean isValid(String s){
        int cnt=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(') cnt++;
            if(s.charAt(i) == ')') cnt--;
            if(cnt < 0){
                return false;
            }
        }

        return (cnt==0)? true:false;
    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        if(s == null){
            return ans;
        }

        HashSet<String> vis = new HashSet<>();
        Deque<String> dq = new ArrayDeque<>();

        dq.addLast(s);
        vis.add(s);

        boolean flag= false;

        while(dq.size() > 0){
            String rem = dq.removeFirst();

            if(isValid(rem)){
                ans.add(rem);
                flag=true;
            }

            if(flag){
                continue;
            }

            for(int i=0;i<rem.length();i++){
                if(rem.charAt(i)!= '(' && rem.charAt(i)!=')'){
                    continue;
                }

                String ns = rem.substring(0,i) + rem.substring(i+1);
                if(vis.contains(ns) == false){
                    dq.addLast(ns);
                    vis.add(ns);
                }
            }
        }

        return ans;
    }
}
