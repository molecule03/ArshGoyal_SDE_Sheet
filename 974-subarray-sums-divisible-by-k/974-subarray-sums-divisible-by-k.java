class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        
        for(int i : nums){
            sum = (sum+i)%k;
            if(sum < 0) sum += k;
            
            if(map.containsKey(sum)){
                count += map.get(sum);
            }
            
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        
        return count;
    }
}