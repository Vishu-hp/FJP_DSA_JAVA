// great problem on recursion
// some tinkering required in recursion

class Solution {
    Map<String, Boolean> memo;
    public boolean solve(int[] matchsticks, int idx, int a, int b, int c, int d, long side){
        if(a > side || b>side || c>side || d>side) return false;

        if(a == side && b==side && c==side) return true;

        if(idx == matchsticks.length){
            if(a == side && b==side && c==side){
                return true;
            }
            return false;
        }

        String key = a + "-" + b + "-" + c + "-" + d;

        if(memo.containsKey(key)){
            return memo.get(key);
        }

        boolean subans1 = solve(matchsticks, idx-1, a+matchsticks[idx],b,c,d, side);
        if(subans1) return true;
        
        boolean subans2 = solve(matchsticks, idx-1, a,b+matchsticks[idx],c,d, side);
        if(subans2) return true;
        
        boolean subans3 = solve(matchsticks, idx-1, a,b,c+matchsticks[idx],d, side);
        if(subans3) return true;
        
        boolean subans4 = solve(matchsticks, idx-1, a,b,c,d + matchsticks[idx], side);
        if(subans4) return true;
        
        memo.putIfAbsent(key, false); 

        return false;
    }

    public boolean makesquare(int[] matchsticks) {
        long sum = 0;
        for(int x: matchsticks){
            sum += x;
        }

        if(sum%4 != 0) return false;

        memo = new HashMap<>();

        Arrays.sort(matchsticks);

        return solve(matchsticks, matchsticks.length-1, 0, 0, 0, 0, sum/4);
    }
}
