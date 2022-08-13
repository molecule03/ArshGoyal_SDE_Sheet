​
if(curSum == totSum) return true;
​
if(dp[n][totSum] != null) return dp[n][totSum];
​
boolean ans = false;
if(nums[n-1] < totSum){
ans = getSum(nums, curSum+nums[n-1], totSum-nums[n-1], n-1) || getSum(nums, curSum, totSum, n-1);
}
else{
ans = getSum(nums, curSum, totSum, n-1);
}
​
dp[n][totSum] = ans;
return ans;
}
/// top down which is wrong
public boolean canPartition(int[] nums) {
int n = nums.length;
int sum = 0;
for(int i : nums){
sum += i;
}
boolean dp[][] = new boolean[n+1][sum+1];
for(int i=0; i<n+1; i++){
for(int j=0; j<sum+1; j++){
if(i==0 || j==0)
dp[i][j] = false;
}
}
for(int i=1; i<n+1; i++){
for(int j=1; j<sum+1; j++){
if(nums[i-1] < j){
dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
}
else{
dp[i][j] = dp[i-1][j];
}
}
}
return dp[n][sum];
}