class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        
        int mod = 1000000007;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        long maxl = horizontalCuts[0]-0;
        int nexth = 0;
        long hsize = horizontalCuts.length;
        for(int i=0; i<hsize; i++){
            if(i == hsize-1)
                nexth = h;
            else       
                nexth = horizontalCuts[i+1];
            
            long curh = horizontalCuts[i];
            
            maxl = Math.max(maxl, (nexth-curh));
        }
        
        long maxb = verticalCuts[0]-0;
        int nextv = 0;
        long vsize = verticalCuts.length;
        for(int i=0; i<vsize; i++){
            if(i == vsize-1)
                nextv = w;
            else       
                nextv = verticalCuts[i+1];
            
            long curv = verticalCuts[i];
            
            maxb = Math.max(maxb, (nextv-curv));
        }
        
        
        long maxArea = (maxb*maxl)%mod; 
        // System.out.println(maxl);
        
        
        return (int)maxArea;
        
    }
}