// https://www.geeksforgeeks.org/count-number-of-ways-to-partition-a-set-into-k-subsets/
// TABULATION 

import java.util.*;
import java.io.*;
 
class GFG{

static int countP(int n, int k) 
{ 
    int[][] dp = new int[n+1][k+1]; 
     
    // Base cases 
    for (int i = 0; i <= n; i++) 
    dp[i][0] = 0; 
    for (int i = 0; i <= k; i++) 
    dp[0][k] = 0; 
     
    
    for (int i = 1; i <= n; i++) 
    for (int j = 1; j <= k; j++) 
    if (j == 1 || i == j) 
        dp[i][j] = 1; 
    else
        dp[i][j] = j * dp[i - 1][j] + dp[i - 1][j - 1]; 
         
        return dp[n][k]; 
     
} 
 
  public static void main(String[] args ) 
  { 
      System.out.println(countP(5, 2)); 
  } 
}
