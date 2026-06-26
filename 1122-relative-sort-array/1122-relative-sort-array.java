class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int[] count = new int[1001];

        // Count frequency of each number
        for (int i = 0; i < arr1.length; i++) {
            count[arr1[i]]++;
        }

        int index = 0;

        // Place elements according to arr2
        for (int i = 0; i < arr2.length; i++) {

            while (count[arr2[i]] > 0) {
                arr1[index] = arr2[i];
                index++;
                count[arr2[i]]--;
            }

        }

        // Place remaining elements in ascending order
        for (int i = 0; i < count.length; i++) {

            while (count[i] > 0) {
                arr1[index] = i;
                index++;
                count[i]--;
            }

        }

        return arr1;
    }
}