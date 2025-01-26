// great problem on binary search

class Solution {
    public boolean isPossible(int mountainHeight, int[] workerTimes, long possAns){
        long possibleCut = 0;

        for(int time: workerTimes){
            long start= 1, end = mountainHeight;
            long subCut = 0;

            while(start<=end){
                long mid = (start + end) / 2;
                long cost = (mid)*(mid+1)/2 * time;

                if(cost <= possAns){
                    subCut = mid;
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }

            if(subCut >= mountainHeight || possibleCut >= mountainHeight) return true;
            
            possibleCut += subCut;
        }

        return possibleCut >= mountainHeight;
    }

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long start = 0, end = (long)1e18;
        long ans = 0;

        while(start<=end){
            long mid = (start+end)/2;

            if(isPossible(mountainHeight, workerTimes, mid)){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }

        return ans;
    }
}
