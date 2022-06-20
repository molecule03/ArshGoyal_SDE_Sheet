class Solution {
    public boolean canJump(int[] nums) {
        
        int goodInd = nums.length-1;
        
        for(int i=nums.length-1; i>=0; i--){
            if(i+nums[i] >= goodInd){
                goodInd = i;
            }
        }
        
        if(goodInd == 0) return true;
        
        
        return false;
    }
}