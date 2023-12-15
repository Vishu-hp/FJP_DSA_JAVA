class Solution 
{ 
    long getSubstringWithEqual012(String str) 
    { 
        // code here
        long ans=0;
        HashMap<String, Integer>mp = new HashMap<>();
        int no=0, n1=0, n2=0;
        mp.put("0#0",1);
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch == '0'){
                no++;
            }
            else if(ch == '1'){
                n1++;
            }
            else{
                n2++;
            }
            
            String str2 = (n1-no)+"#"+(n2-n1);
            
            // if(str2 == "0#0"){
            //     ans += 1;
            // }
            
            if(mp.containsKey(str2)){
                ans += mp.get(str2);
                int val = mp.get(str2);
                mp.put(str2, val+1);
            }
            else{
                mp.put(str2, 1);
            }
        }
        return ans;
    }
} 
