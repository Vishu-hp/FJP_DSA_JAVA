// hashmap use 

class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        HashMap<String, Boolean> frq = new HashMap<>();

        for(String str: bannedWords){
            frq.put(str, true);
        }

        int cnt = 0;
        for(String str: message){
            if(frq.containsKey(str)){
                cnt++;

                if(cnt >=2){
                    return true;
                }
            }
        }

        return false;
    }
}
