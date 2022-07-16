class Solution {
    public int mostFrequent(int[] nums, int key) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == key){
                map.put(nums[i+1], map.getOrDefault(nums[i+1], 0)+1);
            }
        }
        
        int most = 0;
        int ans = 0;
        for(int i :map.keySet()){
            if(map.get(i) > most){
                most = map.get(i);
                ans = i;
            }
        }
        
        return ans;
    }
}