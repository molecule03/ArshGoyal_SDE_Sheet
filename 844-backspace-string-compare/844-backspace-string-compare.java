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
        
        if(ss.size() != tt.size()) return false;
        
        int size = ss.size();
        for(int i=0; i<size; i++){
            if(ss.pop() != tt.pop())
                return false;
        }
        
        return true;
    }
}