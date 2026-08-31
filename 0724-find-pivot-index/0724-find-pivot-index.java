class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0;

        for(int n: nums){
            total+= n;
        }
        int lSum =0;

        for(int i =0;i<nums.length;i++){

            int rightSum = total - lSum - nums[i];

            if(rightSum == lSum){
                return i;
            }
            lSum += nums[i];
        }
        return -1;
    }
}