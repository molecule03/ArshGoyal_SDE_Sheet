class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        
        
// Smallest element from the left
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
        
// Emptying the stack to resuse it again
        while(!st.isEmpty()) st.pop();
        
// Smallest element from the right
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
        
// Considering the height and the boundary and calculating the area
        int maxArea = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            
            int curArea = (rightS[i]-leftS[i]+1)*(heights[i]);
            
            maxArea = Math.max(curArea, maxArea);
        }
        
        
        return maxArea;
    }
}