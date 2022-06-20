class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int n = cardPoints.length;
        
        int lSum = 0;
        int rSum = 0;
        for(int i=n-1; i>=n-k; i--){  // taking sum of last k cards
            rSum += cardPoints[i];
        }
        
        
        int maxPoints = rSum;
        int i=0, j=(n-k);
        for(int l=0; l<k; l++){
            int points = 0;
           
            lSum += cardPoints[i++];
            rSum -= cardPoints[j++];
            
            points = lSum+rSum;
            System.out.println(points);
            maxPoints = Math.max(points, maxPoints);
        }
        
        // maxPoints = Math.max(lSum, maxPoints);
        
        return maxPoints;
    }
}