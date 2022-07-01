class Solution {
    public int countHousePlacements(int n) {
        if(n == 1) return 4;
        if(n == 2) return 9;
        
        int mod = 1000000007;
        
        long[] val = new long[n];
        
        val[1] = 2;
        val[2] = 3;
        for(int i=3; i<n; i++){
            val[i] = (val[i-1]+val[i-2])%mod;
        }
        
        long ans = (val[n-1]+val[n-2])%mod;
        
        long lav = (ans*ans)%mod;
        
        return (int)lav;
    }
}


// 1 = 2;
// 2 = 3;
// 3 = 5;
// 4 = 8;
// 5 = 13;


// 98
// 99
// 100
