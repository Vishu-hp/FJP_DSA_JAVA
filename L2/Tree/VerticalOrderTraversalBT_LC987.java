// CUSTOM PRIORITY QUEUE USING LAMBDA OPERATOR

class Solution {
    class Pair{
        TreeNode nd;
        int lev;

        Pair(TreeNode nd, int lev){
            this.nd = nd;
            this.lev = lev;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        PriorityQueue<Pair> main = new PriorityQueue<>((a,b)->{
            return a.nd.val - b.nd.val;
        });
        PriorityQueue<Pair> help = new PriorityQueue<>((a,b)->{
            return a.nd.val - b.nd.val;
        });

        HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();
        int mnl = Integer.MAX_VALUE, mxl = Integer.MIN_VALUE;

        main.add(new Pair(root, 0));

        while(main.size() > 0){
            Pair rem = main.remove();

            mnl = Math.min(mnl , rem.lev);
            mxl = Math.max(mxl, rem.lev);

            if(mp.containsKey(rem.lev)){
                ArrayList<Integer> tmp = mp.get(rem.lev);
                tmp.add(rem.nd.val);
                mp.put(rem.lev, tmp);
            }
            else{
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(rem.nd.val);
                mp.put(rem.lev, tmp);
            }

            if(rem.nd.left != null){
                help.add(new Pair(rem.nd.left, rem.lev-1));
            }

            if(rem.nd.right != null){
                help.add(new Pair(rem.nd.right, rem.lev+1));
            }

            if(main.size() == 0){
                PriorityQueue<Pair> tmp = main;
                main = help;
                help = tmp;
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=mnl;i<=mxl;i++){
            List<Integer> tmp = new ArrayList<>();

            for(Integer x: mp.get(i)){
                tmp.add(x);
            }

            ans.add(tmp);
        }
        return ans;
    }
}
