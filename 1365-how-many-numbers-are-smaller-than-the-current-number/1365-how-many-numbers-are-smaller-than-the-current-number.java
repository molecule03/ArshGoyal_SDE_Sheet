class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        
        // int[] temp = new int[nums.length];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            list.add(nums[i]);
        }
        Collections.sort(list);
        
        for(int i=0; i<nums.length; i++){
            int x = nums[i];
            nums[i] = list.indexOf(x);
        }
        
        return nums;
    }
}