// https://leetcode.com/problems/binary-tree-right-side-view/

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>ans = new ArrayList<>();
        if(root == null){
            return ans;
        }


        Queue<TreeNode>q = new ArrayDeque<>();
        q.add(root);

        while(q.size() > 0){
            int n = q.size();
            for(int i=1;i<=n;i++){
                TreeNode rem = q.remove();

                if(i==n){
                    ans.add(rem.val);
                }

                if(rem.left != null){
                    q.add(rem.left);
                }

                if(rem.right != null){
                    q.add(rem.right);
                }
            }
        }

        return ans;
    }
}
