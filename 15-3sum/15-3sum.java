class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        int n = nums.length;
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<n-2; i++){
            if(i>0 && (nums[i-1] == nums[i])){ // to avoid duplicates
                continue;
            }
                int sum = 0-nums[i];
                int lo = i+1;
                int hi = n-1;

                while(lo < hi){
               
                    if(nums[lo]+nums[hi] == sum){
                        res.add(Arrays.asList(nums[hi], nums[lo], -sum));
                        while(lo < hi && nums[hi] == nums[hi-1]) hi--;
                        while(lo < hi && nums[lo] == nums[lo+1]) lo++;
                        lo++;
                        hi--;
                    }
                    else if(nums[lo]+nums[hi] < sum){
                        lo++;
                    }
                    else
                        hi--;
                }
        }
        
        return res;
    }
}