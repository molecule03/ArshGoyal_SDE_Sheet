class Solution {
    public String frequencySort(String s) {
        
        char nums[] = s.toCharArray();
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char c: nums){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        List<int[]> list = new ArrayList<>();
        for(char c : map.keySet()){
            int[] arr = {(int)c, map.get(c)};
            list.add(arr);
        }
        
        Collections.sort(list, (a,b)->(int)b[1]-(int)a[1]);
        
        int j=0;
        for(int[] c : list){
            for(int i=0; i<(int)c[1]; i++){
                nums[j++] = (char)c[0];
            }
        }
        
        // System.out.println(nums);
        
        StringBuilder sb = new StringBuilder();
        for(char c : nums){
            sb.append(c);
        }
        
        // return nums;
        return sb.toString();
    }
}