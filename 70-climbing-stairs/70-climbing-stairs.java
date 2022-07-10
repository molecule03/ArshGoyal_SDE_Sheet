class Solution {
    Integer dp[] = new Integer[46];
    public int climbStairs(int n) {
        if(n < 2) return 1;
        
        if(dp[n] != null) return dp[n];
        int climbs = climbStairs(n-1)+climbStairs(n-2);
        
        dp[n] = climbs;
        return climbs;
    }
}