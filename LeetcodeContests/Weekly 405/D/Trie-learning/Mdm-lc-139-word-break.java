// Trie and dp problem

class Solution {
    class TrieNode{
        ArrayList<TrieNode> child;
        boolean flag;

        TrieNode(){
            child = new ArrayList<>();

            for(int i=0; i<26; i++){
                child.add(null);
            }

            flag = false;
        }
    }

    class Trie{
        TrieNode root;

        Trie(){
            root = new TrieNode();
        }

        void insert(String word){
            TrieNode curr = root;

            for(int i=0; i<word.length(); i++){
                int idx = word.charAt(i) - 'a';

                if(curr.child.get(idx) == null){
                    curr.child.set(idx, new TrieNode());
                }

                curr = curr.child.get(idx);
            }

            curr.flag = true;
        }

        boolean search(String word){
            TrieNode curr = root;

            for(int i=0; i<word.length(); i++){
                int idx = word.charAt(i) - 'a';

                if(curr.child.get(idx) == null){
                    return false;
                }

                curr = curr.child.get(idx);
            }

            return curr.flag;
        }

        boolean wordStartsWith(String word){
            TrieNode curr = root;

            for(int i=0; i<word.length(); i++){
                int idx = word.charAt(i) - 'a';

                if(curr.child.get(idx) == null){
                    return false;
                }

                curr = curr.child.get(idx);
            }

            return true;
        }
    }

    boolean helper(Trie tr, String s, int[][] memo, int idx){
        if(idx >= s.length()){
            return true;
        }

        if(memo[idx][s.length()-1] != -1){
            return memo[idx][s.length()-1]==1 ? true : false;
        }

        for(int i=idx;i<s.length(); i++){
            String substr = s.substring(idx, i+1);

            if(tr.search(substr)){
                if(helper(tr, s, memo, i+1)){
                    memo[idx][s.length()-1] = 1;
                    return true;
                }
            }
        }

        memo[idx][s.length()-1] = 0;
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Trie tr = new Trie();

        for(String word: wordDict){
            tr.insert(word);
        }

        int n = s.length();
        int[][] memo =new int[n][n];
        for(int i=0; i< n;i++){
            Arrays.fill(memo[i], -1);
        }
        return helper(tr, s, memo, 0);
    }
}
