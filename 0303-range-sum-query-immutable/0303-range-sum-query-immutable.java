class NumArray {
    int[] ps;
    public NumArray(int[] nums) {
      ps = new int[nums.length+1]  ;
      for(int i=0;i<nums.length;i++){
        ps[i+1] = ps[i]+nums[i];
      }
    }
    
    public int sumRange(int left, int right) {
        return ps[right+1]-ps[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */