class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    public static ArrayList<Node> nodeToRoot(Node root, int tar){
        if(root ==null){
            ArrayList<Node> sa = new ArrayList<>();
            return sa;
        }
        
        if(root.data == tar){
            ArrayList<Node> sa = new ArrayList<>();
            sa.add(root);
            return sa;
        }
        
        ArrayList<Node> lc = nodeToRoot(root.left, tar);
        if(lc.size() > 0){
            lc.add(root);
            return lc;
        }
        
        ArrayList<Node> rc = nodeToRoot(root.right, tar);
        if(rc.size() > 0){
            rc.add(root);
            return rc;
        }
        
        return rc;
    }
    
    public static int height(Node node, Node blk){
        if(node == null || node == blk){
            return -1;
        }
        
        return Math.max(height(node.left, blk), height(node.right, blk)) + 1;
    }
    
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        ArrayList<Node> ntr = nodeToRoot(root, target);
        
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<ntr.size();i++){
            int ht;
            if(i==0){
                ht = height(ntr.get(i), null);
            }
            else{
                ht = height(ntr.get(i), ntr.get(i-1));
            }
            
            ans = Math.max(ans, ht+i);
        }
        return ans;
    }
}
