class Solution {
    public int[] getAverages(int[] nums, int k) {

        int[] res = new int[nums.length];
        int n = nums.length;
        Arrays.fill(res, -1);
        int left = 0;
        int right = 0;
        int w = 2 * k + 1;
        long sum = 0;       
        if (w > n) {
            return res;
        }        
        while (right < w) {
            sum += nums[right];
            right++;
        }
        res[k++] = (int)(sum / w);        
        while (right < n) {
            sum += nums[right];
            sum -= nums[left];
            res[k++]= (int) (sum/w);
            left++;
            right++;            
        }
        return res;
    }
}