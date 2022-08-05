class Solution {
   public int combinationSum4(int[] nums, int target) {
    // at start, none of the values are computed
       int dp[] = new int[target+1];
       dp[0] = 1;
       for (int curTarget = 1; curTarget <= target; curTarget++){ 
           for (int num : nums){    // check for all elements from nums
               if (num <= curTarget)  // an element will only be taken if it is less than target to be achieved
                   // the optimal answer(no. of combination) of remaining value is added to dp[curTarget]
                   dp[curTarget] += dp[curTarget - num];  
           }
       }
       
       return dp[target];
    }
}