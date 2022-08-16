class Solution {
    public int firstUniqChar(String s) {
        
        int chars[] = new int[26];
        
        for(char c: s.toCharArray()){
            chars[c-'a']++;
        }
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(chars[c-'a'] == 1) return i;
        }
        
        
        return -1;
    }
}