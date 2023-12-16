import java.util.*;

public class Solution {

	public static int solution(int[] arr) {
		// write your code here
        int ans=1;

        for(int i=0; i<arr.length;i++){
            int mn = arr[i];
            int mx = arr[i];
            HashSet<Integer>st = new HashSet<>();

            for(int j=i;j<arr.length;j++){
                mx = Math.max(mx, arr[j]);
                mn = Math.min(mn, arr[j]);
                st.add(arr[j]);

                if(j-i == mx-mn && st.size() == j-i+1){
                    ans = Math.max(ans, j-i+1);
                }

            }
        }

		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

}
