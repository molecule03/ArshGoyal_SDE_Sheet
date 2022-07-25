class Solution {
    public int search(int[] nums, int target) {
        
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
        
            System.out.println(left);
        if(target == nums[left])
            return left;
        else if(target == nums[nums.length-1]){
            return nums.length-1;
        }
        else if(target < nums[nums.length-1]){
            right = nums.length-1;
        }
        else{
            right = left - 1;
            left = 0;
          
        }
        
        // System.out.println(left+" "+right);
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