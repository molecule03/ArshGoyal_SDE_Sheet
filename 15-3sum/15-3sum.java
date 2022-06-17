class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0; i<nums.length-2; i++){
            
            int l = i+1;
            int h = nums.length-1;
            int sum = 0-nums[i];
            
            while(l < h){
                if(nums[l]+nums[h] == sum){
                    List<Integer> n = Arrays.asList(nums[i],nums[l], nums[h]);
                    Collections.sort(n);
                    if(set.contains(n)){
                        l++;
                        h--;
                        continue;
                    }
                    res.add(n);
                    set.add(n);
                }
                else if (nums[l] + nums[h] < sum) l++;
                else h--;
            }
        }
        
        return res;
    }
}