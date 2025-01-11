// decent A , stringbuilder use

class Solution {
    public String getEncryptedString(String s, int k) {
        StringBuilder str = new StringBuilder();
        str.append(s);

        int n = s.length();
        for (int i = 0; i < n; i++) {
            int idx = (i + k) % n;

            str.setCharAt(i, s.charAt(idx));
        }

        return str.toString();
    }
}
