class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        
        int leftS[] = new int[n];
        for(int i=0; i<n; i++){
            
            while(!st.isEmpty() && heights[i] <= heights[st.peek()])
                st.pop();
            
            if(!st.isEmpty())
                leftS[i] = st.peek()+1;
            else
                leftS[i] = 0;
            
            st.push(i);
        }
        
        
        while(!st.isEmpty()) st.pop();
        
        int rightS[] = new int[n];
        for(int i=n-1; i>=0; i--){
            
            while(!st.isEmpty() && heights[i] <= heights[st.peek()])
                st.pop();
            
            if(!st.isEmpty())
                rightS[i] = st.peek()-1;
            else
                rightS[i] = n-1;
            
            st.push(i);
        }
        
        System.out.println(Arrays.toString(leftS));
        System.out.println(Arrays.toString(rightS));
        
        int maxArea = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            
            int curArea = (rightS[i]-leftS[i]+1)*(heights[i]);
            
            maxArea = Math.max(curArea, maxArea);
        }
        
        
        return maxArea;
    }
}