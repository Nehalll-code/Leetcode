class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0;
        int r = n-1;
        int operations = 0;
        while(l<r){
            int sum = nums[l] + nums[r];
            if(sum==k){
                operations++;
                l++;
                r--;
            }else if(sum<k){
                l++;
            }else{
                r--;
            }
        }
        return operations;
    }
}