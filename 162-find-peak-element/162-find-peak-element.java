class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        
        int lo = 0;
        int hi = nums.length-1;
        
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            
            if(mid-1 >= 0 && mid+1 < nums.length){
                
                if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                    return mid;
                }
                else if(nums[mid+1] > nums[mid]){
                    lo = mid+1;
                }
                else{
                    hi = mid-1;
                }
            }
            else if(mid == 0){
                if(nums[mid] > nums[mid+1]){
                    return mid;
                }
                else{
                    return mid+1;
                }
            }
            else if(mid == nums.length-1){
                if(nums[mid] > nums[mid-1]){
                    return mid;
                }
                else{
                    return mid-1;
                }
            }
        }
        
        return -1;
    }
}