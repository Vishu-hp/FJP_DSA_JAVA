// decent B problem using recursion based on last val 

class Solution {
    public void solve(int currIdx, int n, int lstChar, List<String> ans, StringBuilder asf){
        if(currIdx > n){
            ans.add(asf.toString());
            return;
        }
        
        if(currIdx == 1){
            solve(currIdx+1, n, 0, ans, asf.append("0"));
            asf.deleteCharAt(asf.length()-1);
            solve(currIdx+1, n, 1, ans, asf.append("1"));
            asf.deleteCharAt(asf.length()-1);
        }
        else{
            if(lstChar == 0){
                solve(currIdx+1, n, 1, ans, asf.append("1"));
                asf.deleteCharAt(asf.length()-1);
            }
            else{
                solve(currIdx+1, n, 1, ans, asf.append("1"));
                asf.deleteCharAt(asf.length()-1);
                solve(currIdx+1, n, 0, ans, asf.append("0"));
                asf.deleteCharAt(asf.length()-1);
        }
        }
    }
    
    public List<String> validStrings(int n) {
        StringBuilder str = new StringBuilder();
        
        List<String> lst = new ArrayList<>();
        solve(1, n, -1, lst, str);
        return lst;
    }
}
