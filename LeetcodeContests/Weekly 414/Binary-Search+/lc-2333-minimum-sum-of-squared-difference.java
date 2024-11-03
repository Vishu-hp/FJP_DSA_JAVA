// good problem , but didn't use binary search

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int maxDiff = 0;
        long k= k1+k2;
        int[] diffFreq = new int[100001];
        long ans = 0;

        for(int i = 0; i < n; i++){
            int difference = Math.abs(nums1[i] - nums2[i]);
            if(difference == 0){
                continue;
            }

            diffFreq[difference]++;
            maxDiff = Math.max(difference, maxDiff);
        }


        for(int diff = maxDiff; diff > 0 && k > 0; diff--){
            if(diffFreq[diff] > 0){
                if(k >= diffFreq[diff]){
                    k -= diffFreq[diff];
                    diffFreq[diff-1] += diffFreq[diff];
                    diffFreq[diff] = 0;
                }
                else{
                    diffFreq[diff] -= k;
                    diffFreq[diff-1] += k;
                    k = 0;
                }
            }
        }

        for(int diff = maxDiff; diff >= 0; diff--){
            if(diffFreq[diff] > 0){
                ans += (long)Math.pow((long)diff, 2) * diffFreq[diff];
            }
        }

        return ans;
    }
}
