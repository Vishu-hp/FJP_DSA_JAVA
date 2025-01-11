// good problem solved using recursion, can be further optimized

class Solution {
    public int solve(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int idx) {
        for(int i=0; i < needs.size(); i++){
            if(needs.get(i) < 0){
                return 0;
            }
        }

        if(idx == special.size()){
            int remAns = 0, cnt=0;

            for(int i=0; i<needs.size(); i++){
                if(needs.get(i) > 0){
                    remAns += needs.get(i) * price.get(i);
                }
            }
            return remAns;
        }


        int ans = Integer.MAX_VALUE;
        boolean flag= false;
        // take
        for (int i = 0; i < needs.size(); i++) {
            // needs[i] -= special[idx][i];
            if(special.get(idx).get(i) > needs.get(i)){
                flag= true;
                // break;
            }
            needs.set(i, needs.get(i) - special.get(idx).get(i));
        }

        if(!flag){
            ans = Math.min(ans, special.get(idx).get(needs.size()) + solve(price, special, needs, idx));
        }

        for (int i = 0; i < needs.size(); i++) {
            // needs.get(i) += special.get(idx).get(i);
            needs.set(i, needs.get(i) + special.get(idx).get(i));
        }

        // leave
        ans = Math.min(ans, solve(price, special, needs, idx+1));
        
        return ans;
    }

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return solve(price, special, needs, 0);
    }
}
