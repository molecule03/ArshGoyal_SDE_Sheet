class Solution {
public:
    int firstUniqChar(string s) {
        
        vector<int> chars(26); 
        for(char c: s) chars[c-'a']++;
        
        for(int i=0; i<s.size(); i++){
            char c = s[i];
            if(chars[c-'a'] == 1) return i;
        }
        
        
        return -1;
    }
};