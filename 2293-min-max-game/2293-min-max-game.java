class Solution {
    public int minMaxGame(int[] nums) {
        
        
        while(nums.length > 1){
            int n = nums.length/2;
            int res[] = new int[n];
            for(int i=0; i<n; i++){
        res[i] = (i%2)==0 ? Math.min(nums[2*i], nums[(2*i)+1]) : Math.max(nums[2*i], nums[(2*i)+1]);
                
            }
            nums = res;
          
        }
        
        return nums[0];
    }
}