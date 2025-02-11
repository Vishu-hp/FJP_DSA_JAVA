// great problem using stack like structure but can't use stack beacuse of constraint that we will need to
// remove and add multiple times

class Solution {
    public String removeOccurrences(String s, String part) {
        int sLen = s.length();
        char[] ans = new char[sLen];
        int ansIdx = 0;
        char lastPartChar = part.charAt(part.length() - 1);

        for (char ch : s.toCharArray()) {
            ans[ansIdx] = ch;

            boolean flag = false;
            if (ch == lastPartChar) {
                int idx1 = ansIdx, idx2 = part.length() - 1;

                while (idx2 >= 0 && idx1 >= 0 && ans[idx1] == part.charAt(idx2)) {
                    idx1--;
                    idx2--;
                }

                if (idx2 < 0) {
                    ansIdx = idx1 + 1;
                    flag = true;
                }
            }

            if(!flag){
                ansIdx++;
            }
        }

        return new String(ans, 0, ansIdx);

    }
}
