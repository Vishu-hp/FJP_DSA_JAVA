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
    public List<TreeNode> nodeToRootPath(TreeNode root, TreeNode tar){
        if(root == null){
            List<TreeNode>sa = new ArrayList<>();
            return sa;
        }

        if(root == tar){
            List<TreeNode>sa = new ArrayList<>();
            sa.add(root);
            return sa;
        }

        List<TreeNode> lc = nodeToRootPath(root.left, tar);
        if(lc.size() > 0){
            lc.add(root);
            return lc;
        }

        List<TreeNode> rc = nodeToRootPath(root.right, tar);
        if(rc.size() > 0){
            rc.add(root);
            return rc;
        }

        return rc;
    }

    public void printKLevelDown(TreeNode node, TreeNode block, int k,List<Integer> ans){
        if(k<0 || node==null || node==block){
            return;
        }

        if(k==0){
            ans.add(node.val);
            return;
        }

        printKLevelDown(node.left, block, k-1, ans);
        printKLevelDown(node.right, block, k-1, ans);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<TreeNode>ntr =  nodeToRootPath(root, target);
       
       List<Integer>ans = new ArrayList<>();
       for(int i=0; i<ntr.size(); i++){
           if(i==0){
               printKLevelDown(ntr.get(i), null, k,ans);
           }
           else{
               printKLevelDown(ntr.get(i), ntr.get(i-1), k-i,ans);
           }
       }

       return ans;
    }
}
