class Tree
{
     public ArrayList<Integer> diagonal(Node root)
      {
           //add your code here.
           ArrayList<Integer> ans = new ArrayList<>();
           if(root == null){
               return ans;
           }
           Queue<Node> q = new ArrayDeque<>();
           
           q.add(root);
           
           while(q.size() > 0){
               int n = q.size();
               for(int i=0;i<n;i++){
                   Node rem = q.remove();
                   
                   while(rem != null){
                       ans.add(rem.data);
                       if(rem.left != null){
                           q.add(rem.left);
                       }
                       
                       rem = rem.right;
                   }
               }
           }
           return ans;
      }
}
