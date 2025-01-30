// good sliding window problem and d is also same as this

class Solution {
    public long validSubstringCount(String word1, String word2) {
        int cntToMatch = 0, start = 0;
        long ans = 0;
        int[] frq1 = new int[26];
        int[] frq2 = new int[26];

        // no need
        // Arrays.fill(frq1, 0);
        // Arrays.fill(frq2, 0);

        for(int idx=0; idx < word2.length(); idx++){
            frq2[word2.charAt(idx) - 'a']++;
        }


        for(int ci=0; ci < word1.length(); ci++){
            int ch = word1.charAt(ci) - 'a';
            frq1[ch]++;

            if(frq2[ch]>0 && frq1[ch] <= frq2[ch]){
                cntToMatch++;
            }

            while(cntToMatch == word2.length()){
                ans += (word1.length() - ci);
                int startChar = word1.charAt(start) - 'a'; 

                frq1[startChar]--;
                
                if(frq2[startChar] > 0 && frq1[startChar] < frq2[startChar]){
                    cntToMatch--;
                }

                start++;
            }
        }

        return ans;
    }
}
