class Solution {

    public long distributeCandies(int n, int limit) {

        return combinations(n + 2)
             - 3 * combinations(n - (limit + 1) + 2)
             + 3 * combinations(n - 2 * (limit + 1) + 2)
             - combinations(n - 3 * (limit + 1) + 2);
    }

    private long combinations(long x) {

        if (x < 2) return 0;

        return x * (x - 1) / 2;
    }
}