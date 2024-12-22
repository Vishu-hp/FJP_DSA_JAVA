// great problem on dijkstra , and also used sieve for checking prime

class Solution {
    public boolean[] prime;

    public void sieve(){
        for(int i=0; i< prime.length; i++){
            prime[i] = true;
        }

        for(int i=2 ; i*i < prime.length; i++){
            for(int p=i*i ; p < prime.length; p+=i){
                prime[p] = false;
            }
        }
    }

    public int minOperations(int n, int m) {
        prime = new boolean[10001];
        sieve();
        prime[1] = false;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        HashSet<Integer> hs = new HashSet<>();

        if(n == m) {
            if(prime[n]==true || prime[m]==true) return -1;
            
            return m;
        }

        if(prime[n]==true || prime[m]==true) return -1;


        pq.add(new int[]{n, n});        
        hs.add(n);

        while(pq.size() > 0){
            int[] rem = pq.remove();
            int num = rem[0];

            int base = 0;
            while(num > 0){
                int last = num%10;

                if(last != 9){
                    int newNum = rem[0] + (int)Math.pow(10, base);

                    if(newNum == m){
                        return rem[1] + newNum;
                    }

                    if(!hs.contains(newNum) && prime[newNum]==false){
                        pq.add(new int[]{newNum, rem[1] + newNum});
                        hs.add(newNum);
                    }
                }

                if(last != 0){
                    int newNum = rem[0] - (int)Math.pow(10, base);

                    if(newNum == m){
                        return rem[1] + newNum;
                    }

                    if(!hs.contains(newNum) && prime[newNum]==false){
                        pq.add(new int[]{newNum, rem[1] + newNum});
                        hs.add(newNum);
                    }
                }

                num /= 10;
                base++;
            }   
        }
        return -1;
    }
}
