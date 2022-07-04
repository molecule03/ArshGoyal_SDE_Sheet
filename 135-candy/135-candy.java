class Solution {
    public int candy(int[] ratings) {
        
        int n = ratings.length;
        int choc[] = new int[n];
        Arrays.fill(choc, 1);
        
        for(int i=1; i<n; i++){
            if(ratings[i] > ratings[i-1]){
                choc[i] = choc[i-1]+1;
            }
        }
        
        for(int i=n-1; i>0; i--){
            if(ratings[i] < ratings[i-1]){
                choc[i-1] = Math.max(choc[i]+1, choc[i-1]);
            }
        }
        
        // System.out.println(Arrays.toString(choc));
        
        int noOfChoc = 0;
        for(int i : choc){
            noOfChoc += i;
        }
        
        return noOfChoc;
    }
}