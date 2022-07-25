class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1, -1};
        
        int first = 0;
        int last = 0;
        
        int left = 0;
        int right = nums.length-1;
        
        while(left <= right){
             int mid = left + (right - left)/2;
            
          if(nums[mid] < target){
                left = mid+1;
          }
            else if(nums[mid] >= target){
                first = mid;
                right = mid-1;
            }
        }
        // System.out.println(first);
        
        
        left = 0;
        right = nums.length-1;
        last = -1;
         while(left <= right){
             int mid = left + (right - left)/2;
            
          if(nums[mid] <= target){
                last = mid;
              left = mid+1 ;
          }
            else if(nums[mid] > target){
                right = mid-1;
            }
             
        }
        
        if(nums[first] == target && nums[last]==target){
            return new int[]{first, last};
        }
        // System.out.println(last);
       
        
        
        return new int[]{-1, -1};
    }
}