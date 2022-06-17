class Solution {
    public int maxArea(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        
        int left = 0;
        int right = nums.length-1;
        
        int cur = 0;
        while(left<=right){
            
            if(nums[left] > nums[right]){
                cur = (right-left) * nums[right];
                right--;
            }else{
                cur = (right-left) * nums[left];
                left++;
            }
            
            max = Math.max(cur, max);
        }
        
        return max;
    }
}