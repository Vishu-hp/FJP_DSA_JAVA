// RECURSIVE SOLUTION

import java.io.*;
 
class GFG
{
    public static int countP(int n, int k)
    {
       // Base cases
       if (n == 0 || k == 0 || k > n)
          return 0;
       if (k == 1 || k == n)
          return 1;
 
       // S(n+1, k) = k*S(n, k) + S(n, k-1)
       return (k * countP(n - 1, k) 
              + countP(n - 1, k - 1));
    }
 
       public static void main(String args[])
    {
       System.out.println(countP(3, 2));
 
    }
}
