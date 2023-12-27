// https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1

class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    public static class Pair{
        Node nd;
        int lev;
        
        Pair(){}
        
        Pair(Node nd, int lev){
            this.nd = nd;
            this.lev = lev;
        }
    }
    
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        int mn = Integer.MAX_VALUE, mx = Integer.MIN_VALUE;
        HashMap<Integer, Integer>mp = new HashMap<>();
        
        Queue<Pair>q = new ArrayDeque<>();
        q.add(new Pair(root,0));
        
        while(q.size() > 0){
            Pair rem = q.remove();
            
            mn = Math.min(mn, rem.lev);
            mx = Math.max(mx, rem.lev);
            
            if(mp.containsKey(rem.lev) == false){
                mp.put(rem.lev, rem.nd.data);
            }
            
            if(rem.nd.left != null){
                q.add(new Pair(rem.nd.left, rem.lev-1));
            }
            
             if(rem.nd.right != null){
                q.add(new Pair(rem.nd.right, rem.lev+1));
            }
        }
        
        ArrayList<Integer>ans = new ArrayList<>();
        for(int l=mn;l<=mx;l++){
            ans.add(mp.get(l));
        }
        return ans;
    }
}
