class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }
        int sum = 0;
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < nums.length; i++) {
           sum = sum + nums[i];
           rightSum = totalSum - sum;
           leftSum = sum - nums[i];
           if(rightSum==leftSum){
            return i;
           }
       }
       return -1;
   }
}