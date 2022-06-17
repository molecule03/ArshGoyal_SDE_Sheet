class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++){
// Only take positive Integers
            int n = Math.abs(nums[i]);
            
// If num[1] is already negative then then add n i.e 2 to the list as duplicate
            if(nums[n-1] < 0)
                list.add(Math.abs(n));
        
// Mark n-1th idx as -ve
            nums[n-1] = -nums[n-1]; // if n=2 do nums[1] = -nums[1] to mark that 2 has been visited 
        }
        
        return list;
    }
}