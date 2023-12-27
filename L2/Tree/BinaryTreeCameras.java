// https://leetcode.com/problems/binary-tree-cameras/description/

class Solution {
    static int cam;
    int solve(TreeNode root ){
        if(root == null){
            return 2;
        }

        int lc = solve(root.left);
        int rc = solve(root.right);

        if(lc==1 || rc==1){
            cam++;
            return 0;
        }

        if(lc ==0 || rc==0){
            return 2;
        }

        return 1;
    }

    public int minCameraCover(TreeNode root) {
        cam=0;
        int ret = solve(root);
        if(ret == 1){
            cam++;
        }
        return cam;
    }
}
