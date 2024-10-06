// good problem - great for understanding

class Solution {
    public int getUniqChar(String s) {
        int[] frq = new int[26];
        int unq = 0;
        for (char c : s.toCharArray()) {
            if (frq[c - 'a'] == 0) {
                unq++;
            }
            frq[c - 'a']++;
        }
        return unq;
    }

    public int longestSubstring(String s, int k) {
        int unqChar = getUniqChar(s), ans = 0;
        int[] frq = new int[26];

        for (int unq = 1; unq <= unqChar; unq++) {
            int start = 0, ci = 0, cunq = 0, currCntK = 0;
            Arrays.fill(frq, 0);

            while (ci < s.length()) {
                if (cunq <= unq) {
                    if (frq[s.charAt(ci) - 'a'] == 0) cunq++;

                    frq[s.charAt(ci) - 'a']++;

                    if (frq[s.charAt(ci) - 'a'] == k) currCntK++;

                    ci++;
                } else {
                    if (frq[s.charAt(start) - 'a'] == k) currCntK--;
                    frq[s.charAt(start) - 'a']--;
                    if (frq[s.charAt(start) - 'a'] == 0) cunq--;
                    start++;
                }

                if (cunq == unq && cunq == currCntK) {
                    ans = Math.max(ans, ci - start);
                }
            }
        }

        return ans;
    }
}
