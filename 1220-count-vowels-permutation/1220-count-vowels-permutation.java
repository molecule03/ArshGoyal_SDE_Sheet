class Solution {
    
    int mod = 1000000007;
    Map<String, Long> map = new HashMap<>();
    public int countVowelPermutation(int n) {
        
        long total = 0;
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        for(char c : vowels){
            total = (total + getString(n-1, c)) % mod;
        }
        
        return (int)total;
    }
    
    private long getString(int n, char curChar){
        if(n == 0) return 1;
        
        String key = "" + n + curChar;
        if(map.containsKey(key)) return map.get(key);
        
        long total = 0;
        switch(curChar){
            case 'a' :{
                total = (getString(n-1, 'e'));
                break;
            }
            case 'e':{
                total = (getString(n-1, 'a') + getString(n-1, 'i'));
                break;
            }
            case 'i':{
                total = (getString(n-1, 'a')+getString(n-1, 'e')+getString(n-1, 'o')+getString(n-1, 'u'));
                break;
            }
            case 'o':{
                total = (getString(n-1, 'i')+ getString(n-1, 'u'));
                break;
            }
            case 'u':{
                total = (getString(n-1, 'a'));
                break;
            }
        }
        
        map.put(key, total%mod);
        return total%mod;
    }
}