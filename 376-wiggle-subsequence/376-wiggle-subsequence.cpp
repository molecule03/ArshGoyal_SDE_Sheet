class Solution {
    public int wiggleMaxLength(int[] nums) {
        
        int diff[] = new int[nums.length-1];
        
        int j=0;
        for(int i=1; i<nums.length; i++){
            if(nums[i]- nums[i-1] == 0) continue;
            diff[j++] = nums[i]-nums[i-1];
        }

        int count = 1;
        boolean flag = false;
        int k=0;
        
        for(int i : diff){
            if(k == 0){                 // just for 1st element
                if(diff[0]<0){
                    flag = true;
                    k++;
                    count++;
                 }else if(diff[0]>0){
                    flag = false;
                    k++;
                    count++;
                }
                continue;
            }
            
            if(flag){                     // main condition starts from here
                if(i > 0){
                    count++;
                    flag = false;
                }else{
                    continue;
                }
            }else{
                if(i < 0){
                    count++;
                    flag = true;
                }else{
                    continue;
                }
            }
        }
        
        return count;
    }
}