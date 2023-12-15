import java.util.*;


public class Solution {

  public static int solution(int[] arr) {
        int ans = 0;
        HashMap<String,Integer>mp = new HashMap <> ();
        int countz = 0;
        int counto = 0;
        int countt = 0;
        int delta10 = counto - countz;
        int delta21 = countt - counto;
        String key = delta21 + "#" + delta10;
        mp.put(key, -1);
        for (int i = 0; i<arr.length;i++) {
            if(arr[i] == 0){
                countz++;
            }
            else if(arr[i] == 1){
                counto++;
            }
            else{
                countt++;
            }

            delta10 = counto - countz;
            delta21 = countt - counto;
            key = delta21 + "#" + delta10;

            if(mp.containsKey(key)){
                ans = Math.max(ans, i-mp.get(key));
            }
            else{
                mp.put(key, i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }
}
