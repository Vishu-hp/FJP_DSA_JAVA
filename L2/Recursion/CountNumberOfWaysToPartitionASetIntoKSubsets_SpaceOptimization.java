// https://www.geeksforgeeks.org/count-number-of-ways-to-partition-a-set-into-k-subsets/
// DIDN'T UNDERSTOOD THIS ONE PROPERLY

public class Main {
    static int countPartitions(int n, int k)
    {
        // Create an array to store results of subproblems
        int[] dp = new int[n + 1];
 
        // Base cases
        dp[0] = 1;
 
        for (int j = 1; j <= k; j++) {
            int prev = dp[0];
            for (int i = 1; i <= n; i++) {
                int temp = dp[i];
                if (j == 1 || i == j) {
                    dp[i] = 1;
                }
                else {
                    dp[i] = j * dp[i - 1] + prev;
                }
                prev = temp;
            }
        }
 
        // Return the final answer
        return dp[n];
    }
 
    // Driver program
    public static void main(String[] args)
    {
        int n = 5;
        int k = 2;
        System.out.println("Number of partitions: "
                           + countPartitions(n, k));
    }
}
