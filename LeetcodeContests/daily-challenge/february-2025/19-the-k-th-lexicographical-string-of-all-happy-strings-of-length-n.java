// good problem on recursion and backtracking using stringbuilder

class Solution {
    public void solve(StringBuilder sb, int n, char prev, ArrayList<String> al){
        if(sb.length() == n){
            al.add(sb.toString());
            return;
        }

        for(char c = 'a'; c < 'd'; c++){
            if(c != prev){
                sb.append(c);
                solve(sb, n, c, al);
                sb.delete(sb.length()-1, sb.length());
            }
        }
    }

    public String getHappyString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> al = new ArrayList<>();
        solve(sb, n, ' ', al);
        
        return al.size() >= k ? al.get(k-1): "";
    }
}
