class Solution {
    public int nthUglyNumber(int n) {
        
        TreeSet<Long> set = new TreeSet<>();
        set.add(1l);
        for(int i=0; i<n-1; i++){
            long temp = set.pollFirst();
            
            set.add(temp*2);
            set.add(temp*3);
            set.add(temp*5);
        }
        
        return Integer.parseInt(""+set.pollFirst());
    }
}