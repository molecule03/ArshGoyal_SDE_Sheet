class Solution {
    public boolean isSubsequence(String s, String t) {
        
        int idx = 0;
        int count = 0;
        for(int i=0; i<s.length(); i++){
            char cs = s.charAt(i);
            for(int j=idx; j<t.length(); j++){
                        System.out.println(t.charAt(i)+" "+cs);
                if(t.charAt(j) == cs){
                    idx = j+1;
                    count++;
                    // continue;
                    break;
                }
            }
        }
        // System.out.println(count);
        if(count == s.length()) return true;
        
        return false;
    }
}