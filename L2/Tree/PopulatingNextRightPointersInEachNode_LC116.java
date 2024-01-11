/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    // METHOD -1 
    /* public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while(q.size() > 0){
            int n = q.size();
            ArrayList<Node> lev = new ArrayList<>();
            for(int i=1;i<=n;i++){
                Node rem = q.remove();
                lev.add(rem);

                if(rem.left != null){
                    q.add(rem.left);
                }

                if(rem.right != null){
                    q.add(rem.right);
                }
            }

            for(int i= lev.size()-1; i>=0; i--){
                Node nd = lev.get(i);
                if(i == lev.size()-1){
                    nd.next = null;
                }
                else{
                    Node nxt = lev.get(i+1);
                    nd.next = nxt;
                }
            }
        }
        return root;
    } */

    // METHOD - 2
    public Node connect(Node root) {
        Node node = root;

        while(node!=null && node.left!=null){
            Node tmp = node;

            while(true){
                tmp.left.next = tmp.right;

                if(tmp.next == null) break;
                tmp.right.next = tmp.next.left;
                tmp = tmp.next;
            }
            node = node.left;
        }
        return root;
    }
}
