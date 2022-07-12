class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        int target = 0;
        int n = nums.length-1;
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0; i<n-1; i++){
            if(i>0 && (nums[i-1] == nums[i])){ // to avoid duplicates
                continue;
            }
                int newTar = target-nums[i];
                int lo = i+1;
                int hi = n;

                while(lo < hi){
                    int sum = nums[lo]+nums[hi];
                    if(sum == newTar){
                        list.add(Arrays.asList(nums[hi], nums[lo], -newTar));
                        while(lo < hi && nums[hi] == nums[hi-1]) hi--;
                        while(lo < hi && nums[lo] == nums[lo+1]) lo++;
                        lo++;
                        hi--;
                    }
                    else if(sum < newTar){
                        lo++;
                    }
                    else
                        hi--;
                }
        }
        
        return list;
    }
}