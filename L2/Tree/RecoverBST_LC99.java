// ALSO SOLVE THIS USING MORRIS TRAVERSAL (PEPCODING VIDEO)

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
     TreeNode first = null;
     TreeNode sec = null;
     TreeNode prev = null;

    public void inorder(TreeNode root){
        if(root == null){
            return;
        }

        inorder(root.left);

        if(first == null && prev!=null && prev.val > root.val){
            first = prev;
        }
        if(first != null && prev.val > root.val){
            sec = root;
        }
        prev = root;

        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        inorder(root);

        int val1 = first.val;
        int val2 = sec.val;

        first.val = val2;
        sec.val = val1;
    }
}
