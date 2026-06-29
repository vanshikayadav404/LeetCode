class Solution {
    public int[] twoSum(int[] nums, int target) {
        int lp=0;
        int rp=nums.length-1;
        while(lp!=rp){
            if(nums[lp]+nums[rp]==target){
                return new int[]{lp+1, rp+1};
            }
            else if(nums[lp]+nums[rp]<target){
                lp++;
            }
            else{
                rp--;
            }
        }
        return new int[]{};
    }
}