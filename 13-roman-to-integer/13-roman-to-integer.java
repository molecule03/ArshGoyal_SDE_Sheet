class Solution {
    public int romanToInt(String s) {
        
        Map<String, Integer> map = new HashMap<>();
        
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        // map.put("I", 1);
        // map.put("I", 1);
        // map.put("I", 1);
        // map.put("I", 1);
        // map.put("I", 1);
        // map.put("I", 1);
        // map.put("I", 1);
        // map.put("I", 1);
        
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            
            if(i != s.length()-1 && map.containsKey(s.substring(i, i+2))){
                ans += map.get(s.substring(i, i+2));
                // System.out.println(i+" "+ans);
                i++;
            }
            else if(map.containsKey(s.substring(i, i+1))){
                ans += map.get(s.substring(i, i+1));
                // System.out.println(i+" "+ans);
            }
        }
        
        
        return ans;
    }
}