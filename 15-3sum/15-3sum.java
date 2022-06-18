class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        int n = nums.length;
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        List<List<Integer>> res = new ArrayList<>();
        // Collections.sort(new ArrayList());
        for(int i=0; i<n-2; i++){
            if(i==0 || (nums[i-1] != nums[i])){
                
                int sum = 0-nums[i];
                int lo = i+1;
                int hi = n-1;
                // System.out.println(sum);
                while(lo < hi){
                    if(lo != i+1 && hi != n-1){
                        while(hi > 1 && nums[hi] == nums[hi+1]) hi--;
                        while(lo < n-1 && nums[lo] == nums[lo-1]) lo++;
                    }
                    if(lo >= hi) continue;
                    if(nums[lo]+nums[hi] == sum){
                        res.add(Arrays.asList(nums[hi], nums[lo], -sum));
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
        }
        
        return res;
    }
}