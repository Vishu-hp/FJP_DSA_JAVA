class GFG 
{
    //Function to construct the BST from its given level order traversal.
    public class Pair{
        Node par = null;
        int lb = -(int)1e9;
        int rb = (int)1e9;
        
        Pair(){}
        
        Pair(Node par, int lb, int rb){
            this.par = par;
            this.lb = lb;
            this.rb = rb;
        }
    }
    
    public Node constructBST(int[] arr)
    {
        //Write your code here 
        Node root = null;
        
        LinkedList<Pair> q = new LinkedList<>();
        q.addLast(new Pair());
        
        int idx = 0;
        while(q.size() > 0 && idx < arr.length){
            Pair rem = q.removeFirst();
            int el = arr[idx];
            
            if(el < rem.lb || el > rem.rb){
                continue;
            }
            
            idx++;
            Node par = rem.par;
            Node node = new Node(el);
            if(par == null){
                root = node;
            }
            else{
                if(par.data > node.data){
                    par.left = node;
                }
                else{
                    par.right = node;
                }
            }
            
            q.addLast(new Pair(node, rem.lb, node.data));
            q.addLast(new Pair(node, node.data, rem.rb));
        }
        
        return root;
    }
}
