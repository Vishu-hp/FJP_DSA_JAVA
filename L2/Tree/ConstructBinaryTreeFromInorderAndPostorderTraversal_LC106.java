class Solution {
    public TreeNode solve(int[] postorder, int[] inorder, int ps,int pe,int is,int ie){
        if(ps>pe || is>ie){
            return null;
        }

        TreeNode node = new TreeNode(postorder[pe]);
        int idx=0;
        while(inorder[idx]!= postorder[pe]){
            idx++;
        }

        int lnum = idx-is;
        node.left = solve(postorder,inorder,ps,ps+lnum-1,is,idx-1);
        node.right = solve(postorder,inorder,ps+lnum,pe-1,idx+1,ie);

        return node;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return solve(postorder, inorder, 0, postorder.length-1, 0, inorder.length-1);
    }
}
