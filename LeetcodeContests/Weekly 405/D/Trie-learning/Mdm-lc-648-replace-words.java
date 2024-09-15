// good trie problem

class Solution {
    class TrieNode{
        ArrayList<TrieNode> child;
        boolean isEnd;

        TrieNode(){
            child = new ArrayList<TrieNode>();

            for(int i=0; i<26; i++){
                child.add(null);
            }

            isEnd = false;
        }
    }

    class Trie{
        TrieNode root;

        Trie(){
            root = new TrieNode();
        }

        void insert(String word){
            TrieNode curr = root;

            for(char ch: word.toCharArray()){
                int ci = ch - 'a';

                if(curr.child.get(ci) == null){
                    curr.child.set(ci, new TrieNode());
                }

                curr = curr.child.get(ci);
            }

            curr.isEnd = true;
        }

        String search(String word){
            TrieNode curr = root;

            int len = 0;
            for(char ch: word.toCharArray()){
                int ci = ch - 'a';
                len++;

                // System.out.println(curr.child);

                if(curr.child.get(ci) == null){
                    return word;
                }
                else if(curr.child.get(ci).isEnd){
                    return word.substring(0, len);
                }
                else{
                    curr = curr.child.get(ci);
                }
            }

            return word;
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();

        for(String str: dictionary){
            trie.insert(str);
        }

        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");

        for(String word: words){
            sb.append(trie.search(word));
            sb.append(" ");
        }

        String ans = sb.toString().trim();
        return ans;
    }
}
