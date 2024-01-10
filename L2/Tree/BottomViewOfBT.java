class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    class Pair{
        Node nd;
        int lev;
        
        Pair(Node nd, int lev){
            this.nd = nd;
            this.lev = lev;
        }
    }
    
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        ArrayList<Integer>ans = new ArrayList<>();
        
        Queue<Pair> main = new ArrayDeque<>();
        Queue<Pair> help = new ArrayDeque<>();
        
        HashMap<Integer, Integer>mp = new HashMap<>();
        int mnl = Integer.MAX_VALUE, mxl = Integer.MIN_VALUE;
        
        main.add(new Pair(root,0));
        
        while(main.size() > 0){
            Pair rem = main.remove();
            
            mp.put(rem.lev, rem.nd.data);
            
            mnl = Math.min(mnl, rem.lev);
            mxl = Math.max(mxl, rem.lev);
            
            if(rem.nd.left != null){
                help.add(new Pair(rem.nd.left ,rem.lev-1));
            }
            
            if(rem.nd.right != null){
                help.add(new Pair(rem.nd.right ,rem.lev+1));
            }
            
            if(main.size() == 0){
                main = help;
                help = new ArrayDeque<>();
            }
        }
        
        for(int i=mnl; i<=mxl; i++){
            ans.add(mp.get(i));
        }
        
        return ans;
        
    }
}
