class Solution {
   Boolean dp[][];
	public boolean canPartition(int[] nums) {

			int sum = 0;
			for(int i: nums) sum += i;

			dp = new Boolean[nums.length+1][sum+1];

			return getSum(nums, 0, sum, nums.length);
	}

	private boolean getSum(int[] nums, int curSum, int totSum, int n){
			if(n == 0 || totSum == 0) return false;

			if(curSum == totSum) return true;

			if(dp[n][totSum] != null) return dp[n][totSum];

			boolean ans = false;
			if(nums[n-1] < totSum){
					ans = getSum(nums, curSum+nums[n-1], totSum-nums[n-1], n-1) || getSum(nums, curSum, totSum, n-1);
			}
else{
					ans = getSum(nums, curSum, totSum, n-1);
			}

			dp[n][totSum] = ans;
			return ans;
	}
}