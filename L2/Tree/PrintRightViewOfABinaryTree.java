// https://practice.geeksforgeeks.org/problems/right-view-of-binary-tree/1

class Solution{
    //Function to return list containing elements of right view of binary tree.
    ArrayList<Integer> rightView(Node node) {
        //add code here.
        ArrayList<Integer>ans = new ArrayList<>();
        
        Queue<Node>cl = new ArrayDeque<>();
        Queue<Node>nl = new ArrayDeque<>();
        
        cl.add(node);
        
        while(cl.size() > 0){
            int n = cl.size();
            
            for(int i=0;i<n;i++){
                Node rem = cl.remove();
                
                if(i == n-1){
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
        
        return ans;
    }
}

