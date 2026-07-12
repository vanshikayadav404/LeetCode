class Solution {

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int sumAlice = 0;
        int sumBob = 0;

        for (int x : aliceSizes)
            sumAlice += x;

        for (int x : bobSizes)
            sumBob += x;

        int diff = (sumBob - sumAlice) / 2;

        HashSet<Integer> set = new HashSet<>();

        for (int x : bobSizes)
            set.add(x);

        for (int a : aliceSizes) {

            if (set.contains(a + diff)) {
                return new int[]{a, a + diff};
            }

        }

        return new int[]{};
    }
}