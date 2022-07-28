class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        // System.out.println(s.length() +" "+t.length());
        
        
        Map<Character, Integer> sMap = new HashMap<>();
        for(char c : s.toCharArray()){
            sMap.put(c, sMap.getOrDefault(c, 0)+1);
        }
        
        Map<Character, Integer> tMap = new HashMap<>();
        for(char c : t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c, 0)+1);
        }

        
        for(char c  : tMap.keySet()){
            if(sMap.get(c) == null || sMap.get(c) < tMap.get(c))
                return false;
        }
        
        return true;
    }
}