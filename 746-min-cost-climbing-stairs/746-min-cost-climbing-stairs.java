class Solution {
    Integer dp[] = new Integer[1001];
    
    public int minCostClimbingStairs(int[] cost) {
        
        int n = cost.length;
        int minCost = Math.min(help(n-1, cost), help(n-2, cost));
        
        return minCost;
    }
    
    private int help(int idx, int[] cost){
        if(idx < 0) return 0;
        if(idx==0 || idx==1) return cost[idx];
        
        
        int minCost;
        if(dp[idx] != null){
            return dp[idx];
        }
        else{
            minCost = cost[idx]+Math.min(help(idx-1, cost), help(idx-2, cost));
        }
        
        dp[idx] = minCost;
        return minCost;
    }
}