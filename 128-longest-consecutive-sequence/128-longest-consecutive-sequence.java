class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        
        Arrays.sort(nums);
        
        int curStrick = 1;
        int maxStrick = Integer.MIN_VALUE;
        
        for(int i=1; i<nums.length; i++){
            
            if(nums[i] == nums[i-1]+1 ){
                curStrick++;
            }else if(nums[i] == nums[i-1]){
                continue;
            }else{
                curStrick = 1;
            }
            maxStrick = Math.max(maxStrick, curStrick);
        }
         maxStrick = Math.max(maxStrick, curStrick);
        
        return maxStrick;
    }
}