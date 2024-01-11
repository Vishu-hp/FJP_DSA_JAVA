/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    // Method - 1 (Using node to root path)
    /* public ArrayList<TreeNode> nodeToRoot(TreeNode root, TreeNode nd){
        if(root == null){
            ArrayList<TreeNode> sa = new ArrayList<>();
            return sa;
        }

        if(root.val == nd.val){
            ArrayList<TreeNode> sa = new ArrayList<>();
            sa.add(nd);
            return sa;
        }

        ArrayList<TreeNode> la = nodeToRoot(root.left, nd);
        if(la.size() > 0){
            la.add(root);
            return la;
        }

        ArrayList<TreeNode> ra = nodeToRoot(root.right, nd);
        if(ra.size() > 0){
            ra.add(root);
            return ra;
        }

        return ra;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> ntr1 = nodeToRoot(root, p);
        ArrayList<TreeNode> ntr2 = nodeToRoot(root, q);

        int idx1 = ntr1.size()-1, idx2 = ntr2.size()-1;

        while(idx1>=0 && idx2>=0 && ntr1.get(idx1)==ntr2.get(idx2)){
            idx1--;
            idx2--;
        }

        return ntr1.get(idx1+1);
    } */

    // METHOD - 2 (Using bst property)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if(root == null){
           return null;
       }
       
        TreeNode ans = null;

        if(root.val > p.val && root.val > q.val){
            ans = lowestCommonAncestor(root.left, p, q);
        }
        else if(root.val < p.val && root.val < q.val){
            ans = lowestCommonAncestor(root.right, p, q);
        }
        else{
            ans = root;
        }
        return ans;
    } 
}
