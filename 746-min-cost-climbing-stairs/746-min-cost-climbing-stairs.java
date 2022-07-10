class Solution {
    Integer dp[] = new Integer[1001];
    
    public int minCostClimbingStairs(int[] cost) {
        int minCost = help(-1, cost);
        
        return minCost;
    }
    
    private int help(int idx, int[] cost){
        if(idx >= cost.length){
            return 0;
        }
      
        int minCost;
        if(idx == -1){
             minCost = Math.min(help(idx+1, cost), help(idx+2, cost));
        }
        else if(dp[idx] != null){
            return dp[idx];
        }
        else
             minCost = cost[idx]+Math.min(help(idx+1, cost), help(idx+2, cost));
        
        if(idx == -1) return minCost;
        dp[idx] = minCost;
        return minCost;
    }
}