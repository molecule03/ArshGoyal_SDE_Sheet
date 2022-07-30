class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        
        int freq[] = new int[26];
        Set<Character> wordsInB = new HashSet<>();
        for(String b : words2){
            int temp[] = count(b);
            for(char c : b.toCharArray()){
                wordsInB.add(c);
                freq[c-'a'] = Math.max(freq[c-'a'], temp[c-'a']);
            }
        }
        
        
        List<String> res = new ArrayList<>();
        search : for(String s : words1){
            Map<Character, Integer> map = new HashMap<>();
            for(char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0)+1);
            
            for(char a : wordsInB){
                if(!map.containsKey(a) || map.get(a) < freq[a-'a'])
                    continue search;
            }
            
            res.add(s);
        }
        
        return res;
    }
    
    
    private static int[] count(String b){
        
        int freq[] = new int[26];
        for(char c : b.toCharArray()) freq[c-'a']++;
        
        return freq;
    }
}