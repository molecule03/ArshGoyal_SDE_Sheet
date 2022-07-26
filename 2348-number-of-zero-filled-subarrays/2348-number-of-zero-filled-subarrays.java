class Solution {
    public long zeroFilledSubarray(int[] nums) {
        
        int n= nums.length;
        long count = 0;
        long cur = 0;
        for(int i=0; i<n; i++){
            if(nums[i]==0){
                cur++;
                count+= cur;
            }
            else if(nums[i] != 0){
                cur = 0;
            }
        }
        
        return count;
    }
}