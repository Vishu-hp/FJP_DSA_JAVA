// couldn't implement completely 

class Solution {
    public int numTilePossibilities(String tiles) {
        HashMap<String,Integer> map = new HashMap<>();
        subSequence(map,tiles,"");
        
        // System.out.println(map.size());
        HashSet<String> set = new HashSet<>();
        for(String str : map.keySet()){
            permutation(set,str,"",map);
        }
        
        return map.size()+set.size();
    }
    
    public void permutation(HashSet<String> set,String str,String psf,HashMap<String,Integer> map ){
        if(str.length()==0){
            if(set.contains(psf)==false&&map.containsKey(psf)==false){
                set.add(psf);
            }
        }
        
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            String ros = str.substring(0,i) + str.substring(i+1);
            permutation(set,ros,psf+ch,map);
        }
    }
    
    public void subSequence(HashMap<String,Integer> map,String str,String psf){
        if(str.length()==0){
            if(psf!="")
             map.put(psf,1);
            
            return;
        }
        
        char ch = str.charAt(0);
        String ros = str.substring(1);
        
        subSequence(map,ros,psf+ch);
        subSequence(map,ros,psf);
    }
}
