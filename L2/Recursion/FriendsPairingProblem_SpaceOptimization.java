// https://www.geeksforgeeks.org/problems/friends-pairing-problem5425/1
// WE ONLY NEED (i-1) AND (i-2) VALUES SO WE CAN STORE THEM IN VARIABLES

class Solution
{
    public long countFriendsPairings(int n) 
    { 
       //code here
       int mod = (int)1e9+7;
        if(n<=2){
            return n;
        }
       
       long a=1,b=2,c=0;
       
       for(int i=3;i<=n;i++){
            c = (b + ((i-1) * a)%mod)%mod;
            a=b;
            b=c;
       }
       
       return c;
    }
}    
