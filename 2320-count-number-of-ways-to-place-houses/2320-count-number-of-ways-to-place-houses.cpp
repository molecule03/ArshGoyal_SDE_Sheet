class Solution {
public:
    int countHousePlacements(int n) {
        
        int mod = 1000000007;
        
        long val[n+2];
        
        val[1] = 2;
        val[2] = 3;
        for(int i=3; i<=n; i++){
            val[i] = (val[i-1]+val[i-2])%mod;
        }
        
        long ans = (val[n]*val[n])%mod;
        
        return (int)ans;
    }
};