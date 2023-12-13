// https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/description/

class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer>mp = new HashMap<>();

        for(int val: arr){
            int rem = val%k;

            if(rem < 0){
                rem += k;
            }

            int ov = mp.getOrDefault(rem, 0);
            mp.put(rem, ov+1);
        }

        for(int val: arr){
            int rem = val%k;

            if(rem < 0){
                rem += k;
            }

            if(rem == 0){
                int vl = mp.get(rem);
                if(vl%2 == 1){
                    return false;
                }
            }
            else if(2*rem == k){
                int vl = mp.get(rem);
                if(vl%2 == 1){
                    return false;
                }
            }
            else{
                int v1 = mp.get(rem);
                int v2 = mp.getOrDefault(k-rem, 0);
                if(v1 != v2){
                    return false;
                }
            }
        }
        return true;
    }
}
