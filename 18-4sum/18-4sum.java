class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
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
                long newTar = (long)target-(nums[i]+nums[j]);
                int l = j+1;
                int h =  n;
                // System.out.println("In If "+i+" "+j);
                while(l < h){
                    long sum = (nums[l]+nums[h]);
                    // System.out.println(l+" "+h+" = "+(int)sum);
                    if((sum) == newTar){
                        list.add(Arrays.asList(nums[l], nums[h], nums[i], nums[j]));
                        ++l;
                        --h;
                        while(l<h && nums[l] == nums[l-1]) l++;
                        while(l<h && nums[h] == nums[h+1]) h--;
                       
                    }
                    else if(sum < newTar )
                        l++;
                    else
                        h--;
                }  
            }
        }
        
        return list;
    }
}