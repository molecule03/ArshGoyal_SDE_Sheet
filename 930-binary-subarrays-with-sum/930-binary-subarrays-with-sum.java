class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i : nums){
            sum += i;
            
            if(map.containsKey(sum-goal)){
                count += map.get(sum-goal);
            }
            
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        
        return count;
    }
}