// great trie problem

class Solution {
    class TrieNode{
        TrieNode[] child;

        TrieNode(){
            this.child = new TrieNode[2];
        }
    }

    class Trie{
        TrieNode root;

        Trie(){
            this.root = new TrieNode();
        }

        void insert(int num){
            TrieNode curr = this.root;
            for(int i=31;i>=0;i--){
                int bit = (num>>i) & 1;
                if(curr.child[bit] == null){
                    curr.child[bit]  = new TrieNode();
                }
                curr = curr.child[bit];
            }
        }
    }

    public int findMaximumXOR(int[] nums) {
        Trie tr = new Trie();
        for(int i=0;i<nums.length;i++){
            tr.insert(nums[i]);
        }

        int ans = 0;
        for(int idx=0;idx<nums.length;idx++){
            TrieNode curr = tr.root;
            int currVal = 0;
            int val = nums[idx];
            for(int i=31;i>=0;i--){
                int req = 1-  ((val>>i) & 1);

                if(curr.child[req] != null){
                    currVal |= (1<<i);
                    curr = curr.child[req];
                }
                else{
                    curr = curr.child[1-req];
                }
            }

            ans = Math.max(ans, currVal);
        }

        return ans;
    }
}
