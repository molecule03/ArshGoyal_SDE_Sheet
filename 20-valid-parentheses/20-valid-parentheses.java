class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack();
        
        for(char cur : s.toCharArray()){
            if(cur=='(' || cur=='{' || cur=='['){
                st.push(cur);
                continue;
            }
            
            if(st.isEmpty()) return false;
            
            char last = st.pop();
            if( (cur==')' && last!='(') ||
                (cur=='}' && last!='{') ||
                (cur==']' && last!='[') 
              )
            return false;
        }
        
        return st.isEmpty();
    }
}