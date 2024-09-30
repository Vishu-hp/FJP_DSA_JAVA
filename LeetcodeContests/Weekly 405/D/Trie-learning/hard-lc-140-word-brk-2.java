// solved using backtracking, memo, tabulation
// trie implementation is remaining

class Solution {
// BACKTRACKING
    public void solveBacktracking(int idx, String s, StringBuilder sb, 
    HashSet<String> dict, List<String> ans){
        if(idx == s.length()){
            ans.add(sb.toString().trim());
            return;
        }

        for(int ei = idx+1; ei<= s.length(); ei++){
            String pfx = s.substring(idx, ei);

            if(dict.contains(pfx)){
                int ssf = sb.length();
                sb.append(pfx);
                sb.append(" ");
                solveBacktracking(ei, s, sb, dict, ans);
                System.out.println(sb.toString());
                sb.setLength(ssf);
            }
        }
    }

    // Memoization
    HashMap<String, List<String>> memo;

    public List<String> solveMemoization(String str, HashSet<String> dict){
        if(str.length() == 0){
            List<String> ta = new ArrayList<>();
            ta.add("");
            return ta;
        }

        if(memo.containsKey(str)){
            return memo.get(str);
        }

        List<String> ans = new ArrayList<>();
        for(int idx=1;idx <= str.length(); idx++){
            String pfx = str.substring(0, idx);
            // System.out.println(pfx);

            if(dict.contains(pfx)){
                List<String> subAns = new ArrayList<>();
                subAns = solveMemoization(str.substring(idx), dict);

                for(String idxStr: subAns){
                    System.out.println(idxStr);
                    if(idxStr.length() == 0){
                        ans.add(pfx);
                    }
                    else{
                        ans.add(pfx + " " + idxStr);
                    }
                }
            }
        }

        memo.put(str, ans);
        return ans;
    }

    // Tabulation
    public List<String> solveTabulation(String s, HashSet<String> dict){
        HashMap<Integer , List<String>> tab = new HashMap<>();

        for(int si = s.length()-1; si>=0; si--){
            List<String> subAns = new ArrayList<>();

            for(int ei = si; ei < s.length(); ei++){
                String pfx = s.substring(si, ei+1);

                if(dict.contains(pfx)){
                    if(ei < s.length()-1){
                        List<String> subAns2 = tab.get(ei+1);
                        for(String str: subAns2){
                            subAns.add(pfx + " " + str);
                        }
                    }
                    else{
                        subAns.add(pfx);
                    }
                }
            }

            tab.put(si, subAns);
        }

        for(Map.Entry<Integer, List<String>> me: tab.entrySet()){
            System.out.println(me.getKey()+ " " + me.getValue());
        }

        return tab.get(0);
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>();
        for(String str: wordDict){
            dict.add(str);
        }

        memo =  new HashMap<>();

        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        // solveBacktracking(0, s, sb, dict, ans);

        // ans = solveMemoization(s, dict);

        ans = solveTabulation(s, dict);

        for(String str: ans){
            System.out.println(str);
        }

        return ans;
    }
}
