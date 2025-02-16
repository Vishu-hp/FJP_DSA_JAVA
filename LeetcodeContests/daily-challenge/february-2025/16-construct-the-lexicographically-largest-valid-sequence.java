// understood the approach correctly , but couldn't implement right code by myself

class Solution {
    public boolean solve(int[] ans, int idx, int n, boolean[] vis) {
        if (idx == 2 * n - 1) {
            return true;
        }

        if (ans[idx] > 0) {
            return solve(ans, idx + 1, n, vis);
        } else {
            for (int num = n; num >= 1; num--) {
                if (vis[num])
                    continue;
                vis[num] = true;
                ans[idx] = num;
                if (num == 1) {
                    if (solve(ans, idx + 1, n, vis)) return true;
                } else if (idx + num < ans.length && ans[idx + num] == 0) {
                    ans[num + idx] = num;
                    if (solve(ans, idx + 1, n, vis)) return true;
                    ans[idx + num] = 0;
                }
                ans[idx] = 0;
                vis[num] = false;
            }

        }
        return false;
    }

    public int[] constructDistancedSequence(int n) {
        int[] ans = new int[2 * n - 1];
        Arrays.fill(ans, 0);
        boolean[] vis = new boolean[n + 1];

        solve(ans, 0, n, vis);

        return ans;
    }
}
