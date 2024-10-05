// good sliding window problem and d is also same as this

class Solution {
    public long validSubstringCount(String word1, String word2) {
        ArrayList<Long> word1Frq = new ArrayList<>(Collections.nCopies(26, 0L));
        ArrayList<Long> word2Frq = new ArrayList<>(Collections.nCopies(26, 0L));

        for(char c: word2.toCharArray()){
            word2Frq.set( c - 'a' , word2Frq.get(c - 'a') + 1);
        }

        long ans = 0;
        int start = 0, cntToMat = 0;

        for(int ci=0; ci< word1.length(); ci++){
            char ch = word1.charAt(ci);

            if(word2Frq.get(ch - 'a') > 0 && word1Frq.get(ch - 'a') < word2Frq.get(ch - 'a')){
                cntToMat++;
            }

            word1Frq.set(ch - 'a', word1Frq.get(ch - 'a')+1);

            while(cntToMat == word2.length()){
                ans += word1.length()-ci;
                char startCh = word1.charAt(start);
                word1Frq.set(startCh - 'a', word1Frq.get(startCh - 'a')-1);

                if(word2Frq.get(startCh - 'a') > 0){
                    if(word1Frq.get(startCh - 'a') < word2Frq.get(startCh - 'a')){
                        cntToMat--;
                    }
                }

                start++;
            }
        }
        return ans;
    }
}
