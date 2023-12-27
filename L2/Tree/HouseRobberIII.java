// https://leetcode.com/problems/house-robber-iii/

class Solution {
    public static class Pair{
        int rob, leave;
        Pair(){}

        Pair(int a, int b){
            rob = a;
            leave =b;
        }
    }

    public static Pair solve(TreeNode root){
        if(root == null){
            Pair sa = new Pair(0,0);
            return sa;
        }

        Pair lc = solve(root.left);
        Pair rc = solve(root.right);

        Pair ans = new Pair();
        ans.rob = root.val + lc.leave + rc.leave;
        ans.leave = Math.max(lc.rob, lc.leave) + Math.max(rc.rob, rc.leave);
        return ans;
    }

    public int rob(TreeNode root) {
        Pair ans = solve(root);
        return Math.max(ans.rob, ans.leave);    
    }
}
