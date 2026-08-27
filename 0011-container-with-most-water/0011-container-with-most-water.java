class Solution {
    public int maxArea(int[] height) {
        int j = height.length-1;
        int i = 0;
        int maxA = 0;
        
        while(i<j){
            int width = j-i;
            int h = Math.min(height[i],height[j]);

            int area = width * h;
            maxA = Math.max(maxA,area);
            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }
        return maxA;
    }
}