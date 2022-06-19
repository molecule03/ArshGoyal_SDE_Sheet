class Solution {
    public List<List<Integer>> fourSum(int[] nums, int tar) {
        
        int n = nums.length-1;
        Arrays.sort(nums);
        
        List<List<Integer>> list = new ArrayList<>();
        
        
        for(int i=0; i<n-2; i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j=i+1; j<n-1; j++){
                if(j>i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                long target = (long) tar-(nums[i]+nums[j]);
                int l = j+1;
                int h =  n;
                // System.out.println("In If "+i+" "+j);
                while(l < h){
                    long sum = (nums[l]+nums[h]);
                    // System.out.println(l+" "+h+" = "+(int)sum);
                    if((sum) == target){
                        list.add(Arrays.asList(nums[l], nums[h], nums[i], nums[j]));
                        while(l<h && nums[l] == nums[l+1]) l++;
                        while(l<h && nums[h] == nums[h-1]) h--;
                        l++;
                        h--;
                    }
                    else if(sum < target )
                        l++;
                    else
                        h--;
                }  
                // System.out.println(i+" "+j);
            }
        }
        
        return list;
    }
}