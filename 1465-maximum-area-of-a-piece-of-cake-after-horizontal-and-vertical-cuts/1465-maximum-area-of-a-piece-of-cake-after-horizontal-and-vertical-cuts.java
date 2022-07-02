class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        
        int mod = 1000000007;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        long maxLength = horizontalCuts[0]-0;
        int nexth = 0;
        long hsize = horizontalCuts.length;
        for(int i=0; i<hsize; i++){
            if(i == hsize-1)
                nexth = h;
            else       
                nexth = horizontalCuts[i+1];
            
            long curh = horizontalCuts[i];
            
            maxLength = Math.max(maxLength, (nexth-curh));
        }
        
        long maxBreadth = verticalCuts[0]-0;
        int nextv = 0;
        long wsize = verticalCuts.length;
        for(int i=0; i<wsize; i++){
            if(i == wsize-1)
                nextv = w;
            else       
                nextv = verticalCuts[i+1];
            
            long curv = verticalCuts[i];
            
            maxBreadth = Math.max(maxBreadth, (nextv-curv));
        }
        
        
        long maxArea = (maxBreadth*maxLength)%mod; 
        
        
        return (int)maxArea;
        
    }
}