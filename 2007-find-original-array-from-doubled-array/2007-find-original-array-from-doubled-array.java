class Solution {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length%2 != 0) return new int[]{};
        
        // List<Integer> list = new ArrayList<>();
        // for(int i : changed) list.add(i);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: changed) map.put(i, map.getOrDefault(i, 0)+1);
        
        
        Arrays.sort(changed);
        List<Integer> res = new ArrayList<>();
        for(int i : changed){
            if(map.get(i) == 0)continue;
            if(i == 0 && map.get(i)%2 != 0) continue;
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
        // for(Integer i : list){
        //     Integer a = i;
        //     if(list.contains(a*2)){
        //         res.add(a);
        //         list.remove(a);
        //         Integer l = a*2;
        //         list.remove(l);
        //     }
        // }
        
        // return changed;
        // if(res.size() == changed.length/2){
        //     System.out.println(res);
        // }
        // else{
        //     System.out.println("Isha");
        // }
        
        return ans;
    }
}


   // [1,3,4]
    
  

    