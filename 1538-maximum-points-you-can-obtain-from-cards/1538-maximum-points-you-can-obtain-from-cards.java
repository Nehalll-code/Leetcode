class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int maxSum = 0;
        int lsum = 0, rsum = 0;

        //first k elements sum
        for(int i = 0;i< k ;i++){
            lsum += cardPoints[i];
            maxSum = lsum;
        }

        int rightidx = n-1;
        //removing 1 ele from left and adding one from right in a window
        for(int i = k-1;i>=0;i--){
            lsum -= cardPoints[i];
            rsum += cardPoints[rightidx];
            rightidx--;
            maxSum = Math.max(maxSum,lsum+rsum);
        }

        return maxSum;
    }
}