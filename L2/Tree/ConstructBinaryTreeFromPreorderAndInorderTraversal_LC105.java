class Solution {
    public TreeNode solve(int[] preorder, int[] inorder, int ps,int pe,int is,int ie){
        if(ps>pe || is>ie){
            return null;
        }

        TreeNode node = new TreeNode(preorder[ps]);
        int idx=0;
        while(inorder[idx] != preorder[ps]){
            idx++;
        }

        int lnum = idx-is;
        node.left = solve(preorder, inorder, ps+1,ps+lnum,is,idx-1);
        node.right = solve(preorder, inorder, ps+lnum+1,pe,idx+1,ie);
        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return solve(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
}
