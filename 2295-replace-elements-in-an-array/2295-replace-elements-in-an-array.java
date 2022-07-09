class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], i);
        }
        
        System.out.println(map);
        for(int op[] : operations){           // [1,3]
            if(map.containsKey(op[0])){        //map[1]
                nums[map.get(op[0])]= op[1]; //nums[0] = 3
                map.put(op[1], map.get(op[0]));                                 
            }
        }
        
        
        
        return nums;
    }
}