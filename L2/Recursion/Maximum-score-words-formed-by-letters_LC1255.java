// https://leetcode.com/problems/maximum-score-words-formed-by-letters/description/

class Solution {
    public int solve(String[] words, int idx, int[] farr, int[] score){
        if(idx == words.length){
            return 0;
        }

        int leave = solve(words,idx+1,farr,score);
        int take = 0;

        boolean flag=true;
        int scr=0;
        for(char ch: words[idx].toCharArray()){
            farr[ch-'a']--;
            if(farr[ch-'a'] < 0){
                flag = false;
            }
            scr += score[ch-'a'];
        }

        if(flag){
            take += scr;
            take += solve(words,idx+1,farr,score);
        }

        for(char ch: words[idx].toCharArray()){
            farr[ch-'a']++;
        }

        return Math.max(leave, take);
    }

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] farr = new int[26];
        for(int i=0;i<letters.length;i++){
            char ch = letters[i];
            farr[ch-'a']++;
        }

        return solve(words, 0, farr, score);
    }
}
