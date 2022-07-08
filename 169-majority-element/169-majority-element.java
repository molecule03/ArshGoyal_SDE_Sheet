class Solution {
    public int majorityElement(int[] nums) {
        
        
        int count = 0;
        int element = 0;
        
        for(int i : nums){
         
            
            if(element == i)
                count++;
            else if(count == 0)
                element = i;
            else 
                count --;
        }
        
        return element;
    }
}
