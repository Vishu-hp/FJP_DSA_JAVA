class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer>mp = new HashMap<>();
        for(String s:cpdomains){
            int idx = s.indexOf(' ');
            int num = Integer.valueOf(s.substring(0,idx));
            String s2 = s.substring(idx+1);
            mp.put(s2, mp.getOrDefault(s2,0) + num);

            for(int i=0;i<s2.length();i++){
                if(s2.charAt(i) == '.'){
                    String s3 = s2.substring(i+1);
                    mp.put(s3, mp.getOrDefault(s3,0) + num);
                }
            }
        }

        List<String>ans = new ArrayList<>();
        for(String s: mp.keySet()){
            ans.add(mp.get(s) + " "+ s);
        }
        return ans;
    }
}
