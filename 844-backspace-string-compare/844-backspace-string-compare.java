class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        Stack<Character> ss = new Stack<>();
        for(char ch : s.toCharArray()){
            if( ch == '#' && !ss.isEmpty()){
                ss.pop();
            }
            else if(ch != '#'){
                ss.push(ch);
            }
        }
        
        Stack<Character> tt = new Stack<>();
        for(char ch : t.toCharArray()){
            if( ch == '#' && !tt.isEmpty()){
                tt.pop();
            }
            else if(ch != '#'){
                tt.push(ch);
            }
        }
        
        System.out.println(ss+" "+tt);
        if(ss.size() != tt.size()) return false;
        
        int n = ss.size();
        for(int i=0; i<n; i++){
            char se = ss.pop();
            char te = tt.pop();
            // System.out.println((se-'a')+" "+(te-'a'));
            if(se-'a' != te-'a')
                return false;
        }
        
        return true;
    }
}