class Tree
{
    // Return a list containing the Preorder traversal of the given tree
    void morrisPre(Node node, ArrayList<Integer> ans){
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
                    curr.right = null;
                    node = node.right;
                }
                else{
                    ans.add(node.data);
                    curr.right = node;
                    node = node.left;
                }
            }
        }
    }
    
    ArrayList<Integer> preOrder(Node root)
    {
        // Code
        ArrayList<Integer>ans = new ArrayList<>();
        morrisPre(root, ans);
        return ans;
    }
    
    
}
