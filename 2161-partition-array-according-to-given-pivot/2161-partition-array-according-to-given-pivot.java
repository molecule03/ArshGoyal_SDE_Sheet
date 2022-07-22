class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        
        List<Integer> less = new ArrayList<>();
        List<Integer> great = new ArrayList<>();
        
        int count = 0;
        for(int i : nums){
            if(i == pivot){
                count++;
            }
            else if(i < pivot){
                less.add(i);
            }
            else{
                great.add(i);
            }
        }
        
        int i;
        for(i=0; i<less.size(); i++){
            nums[i] = less.get(i);
        }
        
        // System.out.println(i);
        for(int j=0; j<count; j++){
            nums[i++] = pivot;
        }
         // System.out.println(i);
        for(int j=0; j<great.size(); j++){
            nums[i++] = great.get(j);
        }
        
        return nums;
    }
}