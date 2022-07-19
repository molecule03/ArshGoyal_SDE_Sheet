class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        
        List<List<Integer>> wrapList = new ArrayList<>();
        List<Integer> fl = new ArrayList<>();
        fl.add(1);
        wrapList.add(fl);
        // wrapList.add(Arrays.asList(new int[]{1}));
        for(int i=1; i<numRows; i++){
            List<Integer> list = new ArrayList<>();
            List<Integer> pre = wrapList.get(i-1);
            for(int j=0; j<=i; j++){
                if(j == 0 || j==i){
                    list.add(1);
                }
                else{
                    list.add(pre.get(j)+pre.get(j-1));
                }
            }
            wrapList.add(list);
        }
        
        return wrapList;
    }
}