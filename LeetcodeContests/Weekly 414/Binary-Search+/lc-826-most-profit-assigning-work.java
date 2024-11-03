// tag practice

class Solution {
    public int searchOptimalDiff(ArrayList<Pair<Integer, Integer>> arr
    , int x, int[] psf){
        int ansIdx = -1, s = 0, e = arr.size()-1;

        while(s <= e){
            int mid = s + (e-s)/2;
            int val = arr.get(mid).getKey();

            if(x >= val){
                ansIdx = mid;
                s = mid+1;
            }
            else{
                e = mid-1;
            }
        }

        return ansIdx == -1 ? 0 : psf[ansIdx];
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        ArrayList<Pair<Integer, Integer>> comb = new ArrayList<>();
        int ans = 0, n = difficulty.length, msf=0;
        int[] psf = new int[n];

        for(int i=0; i< n; i++){
            Pair<Integer, Integer> pair = new Pair<>(difficulty[i], profit[i]);
            comb.add(pair);
        }

        Collections.sort(comb, new Comparator<Pair<Integer, Integer>>() {
            public int compare(Pair<Integer, Integer> a, Pair<Integer, Integer> b){
                return a.getKey() - b.getKey();
            }
        });

        msf = comb.get(0).getValue();
        for(int i=0; i < n; i++){
            msf = Math.max(msf, comb.get(i).getValue());
            psf[i] = msf;
        }

        for(int i=0; i < worker.length; i++){
            int maxPftPossible = searchOptimalDiff(comb, worker[i], psf);
            ans += maxPftPossible;
        }

        return ans;
    }
}
