class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {

        
        List<String> res = new ArrayList<>();
        for(String s : words){
            
            Map<Character, Character> cur = new HashMap<>();
            Map<Character, Character> pat = new HashMap<>();
            
            boolean flag = true;
            for(int i=0; i<pattern.length(); i++){
                char to = s.charAt(i);
                char from = pattern.charAt(i);
                
                
                if(!cur.containsKey(to)) cur.put(to ,from);
                if(!pat.containsKey(from)) pat.put(from, to);
                
                if(cur.get(to) != from || pat.get(from) != to){
                    flag = false;
                    break;
                }
            }
            
            
            if(flag && pat.size() == cur.size()) res.add(s);
            
        }
        
        return res;
    }
}