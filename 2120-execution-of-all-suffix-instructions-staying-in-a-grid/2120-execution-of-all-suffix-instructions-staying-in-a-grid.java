class Solution {
    int st;
    int en;
    public int[] executeInstructions(int n, int[] startPos, String s) {
        
        st = startPos[0];
        en = startPos[1];
        int arr[] = new int[s.length()];
        for(int i=0; i<s.length(); i++){
            // Syste
            arr[i] = howMany(st, en, i, n, s);
        }
        
        return arr;
    }
    
    
    private int howMany(int st, int en, int idx, int n, String s){
        if(st<0 || st>=n || en<0 || en>=n ) return -1;
        if(idx == s.length()) return 0;
        
        char c = s.charAt(idx);
        if(c == 'L'){
            return 1+howMany(st, en-1, idx+1, n, s);
        }
        else if(c == 'R'){
            return 1+howMany(st, en+1, idx+1, n, s);
        }
        else if(c == 'U'){
            return 1+ howMany(st-1, en, idx+1, n, s);
        }
        else {
            return 1+howMany(st+1, en, idx+1, n, s);
        }
    }
}