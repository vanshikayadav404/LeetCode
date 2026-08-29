class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
         int n = nums.length;

        // Create a copy and sort it
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        // Map each number to its possible replacement values
        Map<Integer, Queue<Integer>> map = new HashMap<>();

        int start = 0;

        while (start < n) {
            int end = start;

            // Find elements belonging to the same group
            while (end + 1 < n && sorted[end + 1] - sorted[end] <= limit) {
                end++;
            }

            // Store sorted values in their group
            Queue<Integer> queue = new LinkedList<>();

            for (int i = start; i <= end; i++) {
                queue.offer(sorted[i]);
            }
             // Map every value in this group to the same queue
            for (int i = start; i <= end; i++) {
                map.put(sorted[i], queue);
            }

            start = end + 1;
        }

        // Replace each element with the smallest available value
        for (int i = 0; i < n; i++) {
            nums[i] = map.get(nums[i]).poll();
        }

        return nums;
    }
}