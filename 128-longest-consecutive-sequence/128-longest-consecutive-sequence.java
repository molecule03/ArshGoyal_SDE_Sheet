class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
     
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        
        int maxStrick = Integer.MIN_VALUE;
        for(int i : nums){
            if(!set.contains(i-1)){
                int curNum = i;
                int curStrick = 0;
                
                while(set.contains(curNum)){
                    curNum++;
                    curStrick++;
                }
                
                maxStrick = Math.max(maxStrick, curStrick);
            }
            
        }
        
        return maxStrick;
    }
}