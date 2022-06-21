class Solution {
public:
    bool isSubsequence(string s, string t) {
        
        int i = 0;
            for(int j=i; j<t.size(); j++){
                if(s[i] == t[j]){
                    i++;
                    // break;
                }
            }

        
        if(i == s.size()) return true;
        
        return false;
    }
};