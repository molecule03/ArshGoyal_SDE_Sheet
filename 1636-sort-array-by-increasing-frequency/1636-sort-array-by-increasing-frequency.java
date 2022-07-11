class Solution {
    public int[] frequencySort(int[] nums) {
     
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        
        List<int[]> list = new ArrayList<>();
        for(int i : map.keySet()){
            int[] arr = {i, map.get(i)};
            list.add(arr);
        }
        
        Collections.sort(list, (a,b)->(a[1]==b[1])?b[0]-a[0]:a[1]-b[1]);
        
        int j=0;
        for(int[] a : list){
            for(int i=0; i<a[1]; i++){
                nums[j++] = a[0];
            }
        }
        
        return nums;
    }
}