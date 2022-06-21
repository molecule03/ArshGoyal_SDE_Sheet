class Solution {
public:
    bool isSubsequence(string s, string t) {
        
        int idx = 0;
        int count = 0;
        for(int i=0; i<s.size(); i++){
            for(int j=idx; j<t.size(); j++){
                if(s[i] == t[j]){
                    idx = j+1;
                    count++;
                    break;
                }
            }
        }
        
        if(count == s.size()) return true;
        
        return false;
    }
};