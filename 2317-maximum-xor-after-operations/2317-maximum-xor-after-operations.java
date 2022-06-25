class Solution {
    public int maximumXOR(int[] nums) {
        
        int result=0, i = 0;
        int k = 32;
        while( i < k-1) {
            int end = 1 << i;
            int ahe = 0;
            for (int n : nums) {
                if ((end & n) != 0) {
                    ahe = 1;
                    break;
                }
            }
            if (ahe == 2){
                // result |= 1;
                continue;
            }else if(ahe == 1){
                result |= end;
            }
            i++;
        }
        
        return result;
    }

}