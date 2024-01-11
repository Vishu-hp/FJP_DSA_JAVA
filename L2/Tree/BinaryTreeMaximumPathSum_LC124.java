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
    public int mxSum = Integer.MIN_VALUE;

    public int solve(TreeNode root){
        if(root == null) return 0;

        int l = solve(root.left);
        int r = solve(root.right);

        mxSum = Math.max(mxSum, l+r+root.val);

        return Math.max(0, Math.max(l, r) + root.val);
    }

    public int maxPathSum(TreeNode root) {
        int tmp = solve(root);
        return mxSum;    
    }
}
