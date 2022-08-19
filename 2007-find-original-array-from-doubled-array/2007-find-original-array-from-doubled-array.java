class Solution {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length%2 != 0) return new int[]{};
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: changed) map.put(i, map.getOrDefault(i, 0)+1);
        
        if(map.containsKey(0) && map.get(0)%2 != 0) return new int[]{};
        
        Arrays.sort(changed);
        List<Integer> res = new ArrayList<>();
        for(int i : changed){
            if(map.get(i) == 0)continue;
            // if(i == 0 && map.get(i)%2 != 0) continue;
            if(map.containsKey(i*2)  && map.get(i*2) != 0){
                res.add(i);
                map.put(i, map.get(i)-1);
                map.put(i*2, map.get(i*2)-1);
            }
        }
        
        int ans[] = new int[changed.length/2];
        if(res.size() != changed.length/2) return new int[]{};
        
        int j=0;
        for(int i: res){
            ans[j++] = i;
        }
        
        return ans;
    }
}


   // [1,3,4]
    
  

    