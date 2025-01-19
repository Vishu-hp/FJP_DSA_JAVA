// pretty nice problem involving binary search

class Solution {
    public boolean isValid(int[] start, int md, int d){
        int pval = start[0];

        for(int i=1; i < start.length; i++){
            if(pval + md > start[i]+d) return false;
            // this is magic
            pval = Math.max(start[i], pval+md);
        }
        return true;
    }

    public int maxPossibleScore(int[] start, int d) {
        Arrays.sort(start);

        int s = 0, e = Integer.MAX_VALUE, ans=-1;

        while(s <= e){
            int md = s + (e-s)/2;

            if(isValid(start , md, d)){
                ans = md;
                s = md+1;
            }
            else{
                e = md-1;
            }
        }

        return ans;
    }
}
