// LEVELORDER CAN ALSO BE IMPLEMENTED USING ONE QUEUE AS WELL

class Tree
{
    //Function to return list containing elements of left view of binary tree.
    void levelOrder(Node node, ArrayList<Integer> ans){
        Queue<Node>cl = new ArrayDeque<>();
        Queue<Node>nl = new ArrayDeque<>();
        
        cl.add(node);
        while(cl.size() > 0){
            int sz = cl.size();
            for(int i=0;i<sz;i++){
                Node rem = cl.remove();
                
                if(i == 0){
                    ans.add(rem.data);
                }
                
                if(rem.left != null){
                    nl.add(rem.left);
                }
                
                if(rem.right != null){
                    nl.add(rem.right);
                }
            }
            
            if(cl.size() == 0){
                cl = nl;
                nl = new ArrayDeque<>();
            }
        }
    }
    
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      ArrayList<Integer>ans = new ArrayList<>();
      if(root == null){
          return ans;
      }
      
      levelOrder(root, ans);
      return ans;
    }
}
