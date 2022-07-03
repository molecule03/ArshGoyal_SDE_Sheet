class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        
        int mod = 1000000000+7;
        
        long dp[] = new long[n+1];
        dp[1] = 1;
        
        long noOfPeopleSharingSec = 0;
        long ans = 0;
        
        for(int i=2; i<=n; i++){
            long noOfNewPeopleSharingSec = dp[Math.max(i-delay, 0)];
            long noOfPeopleForgeting = dp[Math.max(i-forget, 0)];
            
            noOfPeopleSharingSec += (noOfNewPeopleSharingSec-noOfPeopleForgeting+mod)%mod;
            
            dp[i] = noOfPeopleSharingSec;
        }
        
        for(int i=n-forget+1; i<=n; i++){
            ans = (ans+dp[i])%mod;
        }
        
        return (int)ans;
    }
}