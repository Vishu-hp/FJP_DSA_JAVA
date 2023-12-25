class Solution
{
    // Return a list containing the inorder traversal of the given tree
    void morrisInorder(Node node, ArrayList<Integer> ans){
        while(node != null){
            if(node.left == null){
                ans.add(node.data);
                node = node.right;
            }
            else{
                Node curr = node.left;
                
                while(curr.right!=null && curr.right!=node){
                    curr = curr.right;
                }
                
                if(curr.right == node){
                    ans.add(node.data);
                    curr.right = null;
                    node = node.right;
                }
                else{
                    curr.right = node;
                    node = node.left;
                }
            }
        }
    }
    
    ArrayList<Integer> inOrder(Node root)
    {
        // Code
        ArrayList<Integer>ans = new ArrayList<>();
        morrisInorder(root, ans);
        
        return ans;
    }
    
    
}
