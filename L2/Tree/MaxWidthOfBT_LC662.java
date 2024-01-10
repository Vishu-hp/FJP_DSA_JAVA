/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int ans=0;
        HashMap<TreeNode, Integer> mp = new HashMap<>();
        mp.put(root, 1);

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while(q.size() > 0){
            int n =q.size();
            int start=0, end=0;

            for(int i=0; i<n; i++){
                TreeNode rem = q.remove();

                if(i==0){
                    start = mp.get(rem);
                }

                if(i==n-1){
                    end = mp.get(rem);
                }

                if(rem.left!=null){
                    q.add(rem.left);
                    mp.put(rem.left, 2 * mp.get(rem));
                }

                if(rem.right!=null){
                    q.add(rem.right);
                    mp.put(rem.right, 2 * mp.get(rem) + 1);
                }
            }

            ans = Math.max(ans, end-start+1);
        }
        
        return ans;
    }
}
