class Solution {
    public void moveZeroes(int[] nums) {
        
        int idx = 0;
        for(int i : nums){
            if(i!= 0) nums[idx++] = i;
        }
        
        while(idx < nums.length){
            nums[idx++] = 0;
        }
    }
}