class Solution{
    class Pair{
        int fr;
        int si, ei;
        
        Pair(int fr, int si, int ei){
            this.fr = fr;
            this.si = si;
            this.ei = ei;
        }
    }
  
    ArrayList<Integer> smallestSubsegment(int a[], int n)
    {
        // Complete the function
        HashMap<Integer, Pair>mp = new HashMap<>();
        int mfsi = 0, mf=1, mflen=1;
        for(int i=0;i<a.length;i++){
            if(mp.containsKey(a[i])){
                Pair p = mp.get(a[i]);
                p.fr++;
                p.ei = i;
                mp.put(a[i], p);
                
                int l = i - p.si+1;
                
                if(mf < p.fr){
                    mf = p.fr;
                    mfsi = p.si;
                    mflen = l;
                }
                else if(mf == p.fr && mflen > l){
                    mfsi = p.si;
                    mflen = l;
                }
                else if(mf == p.fr && mflen == l && p.si < mfsi){
                    mfsi = p.si;
                }
            }
            else{
                Pair p = new Pair(1,i,i);
                mp.put(a[i], p);
            }
        }
        
        ArrayList<Integer>ans = new ArrayList<>();
        for(int i=mfsi;i<=mfsi+mflen-1;i++){
            ans.add(a[i]);
        }
        return ans;
    }
  
    
}
