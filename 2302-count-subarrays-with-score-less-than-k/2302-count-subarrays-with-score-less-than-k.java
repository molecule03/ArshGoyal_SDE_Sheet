class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        
        int smalK = 0;
        for(int i=0; i<n; i++){
            if(nums[i] < k){
                smalK++;
            }
        }
        
        
        long count = 0;
        long sum = nums[0];
        long cur = 0;
        long last = 0;
        for(int i=1, j=0; i<n; i++){
         
            sum += nums[i];
            while(j<i && sum*(i-last+1) >= k){
                sum -= nums[j++];
                cur--;
                last = j;
            }
            // if((sum*(i-last+1)) < k){
                // System.out.println(sum);
                cur++;
                count += cur;
            // }
        }
        
        if(count < 0) return smalK;
        
        return count+smalK;
    }
}