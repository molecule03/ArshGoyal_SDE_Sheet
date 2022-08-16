class Solution {
    public int search(int[] nums, int target) {
        if(nums[0] == target) return 0;
        if(nums[nums.length-1] == target) return nums.length-1;
      
        
        // This is to get start point of the array
        int left = 0;
        int right = nums.length-1;
        int ans = 0;
        while(left < right){
            int mid = left + (right-left)/2;
            

            if(nums[mid] > nums[right]){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        
        
        
        // From this we will get to now where the target lies
        if(target == nums[left]){
            return left;
        }
        else if(target < nums[nums.length-1]){
            right = nums.length-1;
        }
        else{
            right = left - 1;
            left = 0;
        }
        
        
        
        // Simple binary Search to find the element
        while(left <= right){
            int mid = left + (right-left)/2;
            
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
    
        return -1;
    }
}