class Solution {
    Map<String, Boolean> map = new HashMap<>();
    int i = 0;
    
    public boolean isInterleave(String s1, String s2, String s3) {
        
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        
        if(len3 != len1+len2){
            return false;
        }
        
        char c1[] = s1.toCharArray();
        char c2[] = s2.toCharArray();
        char c3[] = s3.toCharArray();
        
        return isValid(c1, c2, c3, len1, len2, len3, 0, 0, 0);
    }
    
    private boolean isValid(char[]c1, char[]c2, char[]c3, int len1, int len2, int len3, int p1, int p2,int p3){
        
        if(p3 == len3){
            return (p2==len2 && p1==len1);
        }
        
        String key = new StringBuilder(""+p1+"*"+""+p2+"*"+""+p3).toString();
        
        if(map.containsKey(key)){
            return map.get(key);
        }
        
        if(p1 == len1){
            boolean flag = c2[p2]==c3[p3] ? isValid(c1, c2, c3, len1, len2, len3, p1, p2+1, p3+1) : false;
            map.put(key, flag);
            return map.get(key);
        }
        if(p2 == len2){
            boolean flag = c1[p1]==c3[p3] ? isValid(c1, c2, c3, len1, len2, len3, p1+1, p2, p3+1) : false;
            map.put(key, flag);
            return map.get(key);
        }
        
        boolean one = false, two = false;
        if(c2[p2]==c3[p3]){
            one = isValid(c1, c2, c3, len1, len2, len3, p1, p2+1, p3+1);
        }
        if(c1[p1]==c3[p3]){
            two = isValid(c1, c2, c3, len1, len2, len3, p1+1, p2, p3+1);
        }
        
        map.put(key, (one || two) );
        return map.get(key);
    }
}