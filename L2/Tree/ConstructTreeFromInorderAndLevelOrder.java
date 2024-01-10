class GfG
{
    public Node solve(int[] inord, int[] lev, int is,int ie){
        if(is > ie){
            return null;
        }
        
        Node node = new Node(lev[0]);
        if(lev.length == 1){
            return node;
        }
        
        int idx=0;
        while(inord[idx] != lev[0]){
            idx++;
        }
        
        int[] lols = new int[idx-is];
        int[] lors = new int[ie-idx];
        
        int li=0,ri=0;
        HashSet<Integer> st = new HashSet<>();
        for(int i=is;i<idx;i++){
            st.add(inord[i]);
        }
        
        for(int i=1;i<lev.length;i++){
            int el = lev[i];
            
            if(st.size() > 0 && st.contains(el)){
                lols[li++] = el;
                st.remove(el);
            }
            else{
                lors[ri++] = el;
            }
        }
        
        node.left = solve(inord,lols,is,idx-1);
        node.right = solve(inord,lors,idx+1,ie);
        
        return node;
    }
    
    Node buildTree(int inord[], int level[])
    {
        //your code here
        int len = inord.length;
        return solve(inord,level,0,len-1);
    }
}


