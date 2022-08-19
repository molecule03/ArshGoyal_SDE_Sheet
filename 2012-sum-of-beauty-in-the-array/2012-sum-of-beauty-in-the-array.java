class Solution {
    public int sumOfBeauties(int[] nums) {
        
        int n = nums.length;
        
        boolean left[] = new boolean[n];
        int leftMax = nums[0];
        for(int i=1; i<n; i++){
            if(nums[i] > leftMax){
                left[i] = true;
                leftMax = nums[i];
            }
        }
        
        
        boolean right[] = new boolean[n];
        int rightMin = nums[n-1];
        for(int i=n-2; i>=0; i--){
            if(nums[i] < rightMin){
                right[i] = true;
                rightMin = nums[i];
            }
        }
        
        if(n == 3){
            if(left[1] && right[1]) return 2;
            else if(nums[0]<nums[1] && nums[2]>nums[1]) return 1;
            else return 0;
            
        }
        
        int beauty = 0;
        for(int i=1; i<n-1; i++){
            if(left[i] && right[i]) beauty += 2;
            else if(nums[i-1]<nums[i] && nums[i+1]>nums[i]) beauty += 1;
        }
        
        return beauty;
    }
}

// 1 2 3 4 5
//   1    