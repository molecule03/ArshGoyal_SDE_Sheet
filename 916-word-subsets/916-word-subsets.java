class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        
        int freq[] = new int[26];
        Set<Character> set = new HashSet<>();
        for(String b : words2){
            int temp[] = count(b);
            for(char c : b.toCharArray()){
                set.add(c);
                freq[c-'a'] = Math.max(freq[c-'a'], temp[c-'a']);
            }
        }
        
        
        System.out.println(Arrays.toString(freq));
        
        List<String> res = new ArrayList<>();
        for(String s : words1){
            Map<Character, Integer> map = new HashMap<>();
            for(char c : s.toCharArray()){
                map.put(c, map.getOrDefault(c, 0)+1);
            }
            
           
            boolean flag = true;
            // System.out.println(s);
            for(char c : set){
                // System.out.println(c+" = "+map.get(c)+" \\ "+freq[c-'a']);
                if(!map.containsKey(c) || map.get(c) < freq[c-'a']){
                    flag = false;
                    break;
                }
            }
            
            if(flag){
                res.add(s);
            }
            
        }
        
        
        
        
        
        return res;
    }
    
    
    private static int[] count(String b){
        
        int freq[] = new int[26];
        for(char c : b.toCharArray()){
            freq[c-'a']++;
        }
        
        return freq;
    }
}