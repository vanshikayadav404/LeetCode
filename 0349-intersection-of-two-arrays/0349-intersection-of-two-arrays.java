class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();

        // Store nums1 elements
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

        // Find common elements
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                result.add(nums2[i]);
            }
        }

        // Convert HashSet to array
        int[] ans = new int[result.size()];
        int index = 0;

        for (int num : result) {
            ans[index] = num;
            index++;
        }

        return ans;
    }
}