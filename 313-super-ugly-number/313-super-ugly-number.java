class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        
        TreeSet<Long> set = new TreeSet<>();
        set.add(1l);
        for(int j=0; j<n-1; j++){
            long temp = set.pollFirst();
            
            for(int i=0; i<primes.length; i++){
                set.add(temp*primes[i]);
            }
        }
        
        return set.pollFirst().intValue();
    }
}