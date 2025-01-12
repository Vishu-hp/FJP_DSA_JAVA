// solved from recursion -> rec + memo -> trie -> trie + dp (using string way) -> trie + dp (using words)
// still giving tle (but approaches are correct)

// recursion
class Solution {
    public int solve(String target, String[] words, int[] costs,
            int cost, StringBuilder str) {
        // base case
        if (str.length() >= target.length()) {
            if (str.toString().equals("abcdef")) {

            }
            if (str.toString().equals(target)) {
                return cost;
            }
            return Integer.MAX_VALUE;
        }

        int subAns = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            System.out.println(str + "-1-");
            subAns = Math.min(subAns,
                    solve(target, words, costs, cost + costs[i], str.append(words[i])));
            System.out.println(str + "-2-");
            str.delete(str.length() - words[i].length(), str.length());
        }
        return subAns;
    }

    public int minimumCost(String target, String[] words, int[] costs) {
        int n = words.length;
        boolean[] vis = new boolean[n];
        Arrays.fill(vis, false);

        StringBuilder str = new StringBuilder();
        int ans;
        ans = solve(target, words, costs, 0, str);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}

// *************************************************************************************************************************************************
// recursion + dp
class Solution {
    HashMap<String, Integer> memo;

    public int solve(String target, String[] words, int[] costs,
            int cost, StringBuilder str) {
        // base case
        if (str.length() >= target.length()) {
            if (str.toString().equals("abcdef")) {

            }
            if (str.toString().equals(target)) {
                return cost;
            }
            return Integer.MAX_VALUE;
        }

        String key = str.toString();

        if(memo.containsKey(key)){
            if(memo.get(key) < cost){
                return memo.get(key);
            }
        }

        int subAns = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            System.out.println(str + "-1-");
            subAns = Math.min(subAns,
                    solve(target, words, costs, cost + costs[i], str.append(words[i])));
            System.out.println(str + "-2-");
            str.delete(str.length() - words[i].length(), str.length());
        }

        memo.put(key, subAns);

        return subAns;
    }

    public int minimumCost(String target, String[] words, int[] costs) {
        int n = words.length;
        StringBuilder str = new StringBuilder();
        int ans;
        memo = new HashMap<>();

        ans = solve(target, words, costs, 0, str);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}

// *************************************************************************************************************************************************
// trie using string way
class Solution {
    public class TrieNode {
        HashMap<Integer, TrieNode> children;
        boolean isEnd;
        int cost;

        TrieNode(){
            children = new HashMap<>();
            isEnd = false;
            cost = Integer.MAX_VALUE;
        }
    }

    public class Trie {
        TrieNode root;

        Trie(){
            root = new TrieNode();
        }

        void insert(String word,int cost){
            TrieNode curr = root;
            for(int i=0; i< word.length(); i++){
                int idx = word.charAt(i) - 'a';

                if(!curr.children.containsKey(idx)){
                    curr.children.put(idx,new TrieNode());
                }

                curr = curr.children.get(idx);
            }

            curr.isEnd = true;
            curr.cost = Math.min(curr.cost, cost);
        }

        boolean search(String word){
            TrieNode curr = root;
            for(int i=0; i< word.length(); i++){
                int idx = word.charAt(i) - 'a';

                if(curr.children.containsKey(idx)){
                    curr = curr.children.get(idx);
                }
                else{
                    return false;
                }
            }

            return curr.isEnd;
        }

        int getCost(String word){
            TrieNode curr = root;
            for(int i=0; i< word.length(); i++){
                int idx = word.charAt(i) - 'a';

                if(curr.children.containsKey(idx)){
                    curr = curr.children.get(idx);
                }
                else{
                    return -1;
                }
            }

            return curr.isEnd ? curr.cost : -1;
        }


    }

    public int solve(Trie trie,int idx, String target){
        if(idx >= target.length()){
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        for(int currIdx = idx; currIdx < target.length() ;currIdx++){
            String substr = target.substring(idx, currIdx+1);

            if(trie.search(substr)){
                int cst = trie.getCost(substr);
                System.out.println("1-" + cst);
                int subCost = 0;
                int remCost = solve(trie , currIdx+1, target);
                if(remCost == Integer.MAX_VALUE){
                    subCost = remCost;
                }
                else{
                    subCost = cst + remCost;
                }
                ans = Math.min(ans, subCost);
            }
        }

        return ans;
    }

    public int minimumCost(String target, String[] words, int[] costs) {
        Trie trie = new Trie();

        for(int idx=0; idx < words.length ; idx++){
            trie.insert(words[idx], costs[idx]);
        }

        int ans = solve(trie, 0, target);
        return ans == Integer.MAX_VALUE ? -1: ans;
    }
}

// *************************************************************************************************************************************************
// trie (string way) + dp
class Solution {
    HashMap<Integer, Integer> memo;

    public class TrieNode {
        HashMap<Integer, TrieNode> children;
        boolean isEnd;
        int cost;

        TrieNode(){
            children = new HashMap<>();
            isEnd = false;
            cost = Integer.MAX_VALUE;
        }
    }

    public class Trie {
        TrieNode root;

        Trie(){
            root = new TrieNode();
        }

        void insert(String word,int cost){
            TrieNode curr = root;
            for(int i=0; i< word.length(); i++){
                int idx = word.charAt(i) - 'a';

                if(!curr.children.containsKey(idx)){
                    curr.children.put(idx,new TrieNode());
                }

                curr = curr.children.get(idx);
            }

            curr.isEnd = true;
            curr.cost = Math.min(curr.cost, cost);
        }

        boolean search(String word){
            TrieNode curr = root;
            for(int i=0; i< word.length(); i++){
                int idx = word.charAt(i) - 'a';

                if(curr.children.containsKey(idx)){
                    curr = curr.children.get(idx);
                }
                else{
                    return false;
                }
            }

            return curr.isEnd;
        }

        int getCost(String word){
            TrieNode curr = root;
            for(int i=0; i< word.length(); i++){
                int idx = word.charAt(i) - 'a';

                if(curr.children.containsKey(idx)){
                    curr = curr.children.get(idx);
                }
                else{
                    return -1;
                }
            }

            return curr.isEnd ? curr.cost : -1;
        }


    }

    public int solve(Trie trie,int idx, String target){
        if(idx >= target.length()){
            return 0;
        }

        if(memo.containsKey(idx)){
            return memo.get(idx);
        }

        int ans = Integer.MAX_VALUE;
        for(int currIdx = idx; currIdx < target.length() ;currIdx++){
            String substr = target.substring(idx, currIdx+1);

            if(trie.search(substr)){
                int cst = trie.getCost(substr);
                System.out.println("1-" + cst);
                int subCost = 0;
                int remCost = solve(trie , currIdx+1, target);
                if(remCost == Integer.MAX_VALUE){
                    subCost = remCost;
                }
                else{
                    subCost = cst + remCost;
                }
                ans = Math.min(ans, subCost);
            }
        }

        memo.put(idx, ans);

        return ans;
    }

    public int minimumCost(String target, String[] words, int[] costs) {
        Trie trie = new Trie();
        memo = new HashMap<>();

        for(int idx=0; idx < words.length ; idx++){
            trie.insert(words[idx], costs[idx]);
        }

        int ans = solve(trie, 0, target);
        return ans == Integer.MAX_VALUE ? -1: ans;
    }
}

// *************************************************************************************************************************************************
// trie(word way) + dp
class Solution {
    HashMap<Integer, Integer> memo;

    public class TrieNode {
        HashMap<Integer, TrieNode> children;
        boolean isEnd;
        int cost;

        TrieNode(){
            children = new HashMap<>();
            isEnd = false;
            cost = Integer.MAX_VALUE;
        }
    }

    public class Trie {
        TrieNode root;

        Trie(){
            root = new TrieNode();
        }

        void insert(String word,int cost){
            TrieNode curr = root;
            for(int i=0; i< word.length(); i++){
                int idx = word.charAt(i) - 'a';

                if(!curr.children.containsKey(idx)){
                    curr.children.put(idx,new TrieNode());
                }

                curr = curr.children.get(idx);
            }

            curr.isEnd = true;
            curr.cost = Math.min(curr.cost, cost);
        }

        boolean search(String word){
            TrieNode curr = root;
            for(int i=0; i< word.length(); i++){
                int idx = word.charAt(i) - 'a';

                if(curr.children.containsKey(idx)){
                    curr = curr.children.get(idx);
                }
                else{
                    return false;
                }
            }

            return curr.isEnd;
        }

        int getCost(String word){
            TrieNode curr = root;
            for(int i=0; i< word.length(); i++){
                int idx = word.charAt(i) - 'a';

                if(curr.children.containsKey(idx)){
                    curr = curr.children.get(idx);
                }
                else{
                    return -1;
                }
            }

            return curr.isEnd ? curr.cost : -1;
        }


    }

    public int solve(Trie trie,int idx, String target){
        if(idx >= target.length()){
            return 0;
        }

        if(memo.containsKey(idx)){
            return memo.get(idx);
        }

        int ans = Integer.MAX_VALUE;
        TrieNode curr = trie.root;
        for(int currIdx = idx; currIdx < target.length() ;currIdx++){
            int ch = target.charAt(currIdx) - 'a';

            if(curr.children.containsKey(ch)){
                curr = curr.children.get(ch);

                if(curr.isEnd){
                    int cst = curr.cost;
                    System.out.println("1-" + cst);
                    int subCost = 0;
                    int remCost = solve(trie , currIdx+1, target);
                    if(remCost == Integer.MAX_VALUE){
                        subCost = remCost;
                    }
                    else{
                        subCost = cst + remCost;
                    }
                    ans = Math.min(ans, subCost);
                }
            }
            else{
                break;
            }

            // if(trie.search(substr)){
            //     int cst = trie.getCost(substr);
            //     System.out.println("1-" + cst);
            //     int subCost = 0;
            //     int remCost = solve(trie , currIdx+1, target);
            //     if(remCost == Integer.MAX_VALUE){
            //         subCost = remCost;
            //     }
            //     else{
            //         subCost = cst + remCost;
            //     }
            //     ans = Math.min(ans, subCost);
            // }
        }

        memo.put(idx, ans);

        return ans;
    }

    public int minimumCost(String target, String[] words, int[] costs) {
        Trie trie = new Trie();
        memo = new HashMap<>();

        for(int idx=0; idx < words.length ; idx++){
            trie.insert(words[idx], costs[idx]);
        }

        int ans = solve(trie, 0, target);
        return ans == Integer.MAX_VALUE ? -1: ans;
    }
}
