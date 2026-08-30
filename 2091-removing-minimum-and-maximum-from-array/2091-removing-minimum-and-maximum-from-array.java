class Solution {
    public int minimumDeletions(int[] nums) {
          int n = nums.length;

        int minIndex = 0;
        int maxIndex = 0;

        // Find indices of minimum and maximum elements
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }

            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        int left = Math.min(minIndex, maxIndex);
        int right = Math.max(minIndex, maxIndex);

        // Three possible ways to remove both elements

        // 1. Remove both from the front
        int front = right + 1;

        // 2. Remove both from the back
        int back = n - left;

        // 3. Remove one from front and one from back
        int bothSides = (left + 1) + (n - right);

        return Math.min(front, Math.min(back, bothSides));
    }
}