class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        
        int bCount[] = new int[26];
        for(String b : words2){
            int temp[] = count(b);
            for(char c : b.toCharArray()){
                bCount[c-'a'] = Math.max(bCount[c-'a'], temp[c-'a']);
            }
        }
        
        
        List<String> res = new ArrayList<>();
        search : for(String s : words1){
            int aCount[] = count(s);
            
            for(int i=0; i<26; i++){
                if(aCount[i] < bCount[i])
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