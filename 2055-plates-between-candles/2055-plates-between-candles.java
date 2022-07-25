class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        
        int n = s.length();
        // int ans[] = new int[queries.length];
        
        int preCand[] = new int[n];
         int cand[] = new int[n];
        int idx = -1;
        int count = 0;
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '|'){
                idx = i;
                count++;
            }
            preCand[i] = idx;
            cand[i] = count;
        }
        
        
        int postCand[] = new int[n];
        idx = -1;
        for(int i=n-1; i>=0; i--){
            if(s.charAt(i) == '|'){
                idx = i;
            }
            postCand[i] = idx;
        }
        
        // System.out.println(Arrays.toString(preCand)+" "+Arrays.toString(postCand));
        
        int[] ans = new int[queries.length];
        int itr = 0;
        for(int[] pair : queries){
            int l = postCand[pair[0]];
            int r = preCand[pair[1]];
            int res = 0;
            if(l==-1 || r==-1 || l>=r)
                res = 0;
            else
                res = r - l -(cand[r]-cand[l]);
            
            ans[itr++] = res;
        }
        
        
        return ans;
    }
}