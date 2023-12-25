class Tree {
    void morrisPostorder(Node node, ArrayList<Integer> ans){
        while(node!=null){
            if(node.right == null){
                ans.add(node.data);
                node = node.left;
            }
            else{
                Node curr = node.right;
                
                while(curr.left!=null && curr.left!=node){
                    curr = curr.left;
                }
                
                if(curr.left == node){
                    curr.left = null;
                    node = node.left;
                }
                else{
                    ans.add(node.data);
                    curr.left = node;
                    node = node.right;
                }
            }
        }
    }
    
    ArrayList<Integer> postOrder(Node node) {
        // code here
        ArrayList<Integer>ans = new ArrayList<>();
        morrisPostorder(node, ans);
        
        Collections.reverse(ans);
        return ans;
    }
}
