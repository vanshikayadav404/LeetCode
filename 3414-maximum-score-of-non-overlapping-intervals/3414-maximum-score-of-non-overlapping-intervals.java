import java.util.*;

class Solution {

    static class Interval {
        int start;
        int end;
        int weight;
        int index;

        Interval(int start, int end, int weight, int index) {
            this.start = start;
            this.end = end;
            this.weight = weight;
            this.index = index;
        }
    }

    static class Result {
        long weight;
        List<Integer> indices;

        Result(long weight, List<Integer> indices) {
            this.weight = weight;
            this.indices = indices;
        }
    }

    Interval[] arr;
    Result[][] dp;

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        arr = new Interval[n];

        for (int i = 0; i < n; i++) {

            int start = intervals.get(i).get(0);
            int end = intervals.get(i).get(1);
            int weight = intervals.get(i).get(2);

            arr[i] = new Interval(start, end, weight, i);
        }

        Arrays.sort(arr, (a, b) -> {
            if (a.start != b.start) {
                return Integer.compare(a.start, b.start);
            }

            if (a.end != b.end) {
                return Integer.compare(a.end, b.end);
            }

            return Integer.compare(a.weight, b.weight);
        });

        dp = new Result[n + 1][5];

        Result ans = solve(0, 4);

        int[] result = new int[ans.indices.size()];

        for (int i = 0; i < ans.indices.size(); i++) {
            result[i] = ans.indices.get(i);
        }

        return result;
    }

    private Result solve(int i, int k) {

        if (i == arr.length || k == 0) {
            return new Result(0, new ArrayList<>());
        }

        if (dp[i][k] != null) {
            return dp[i][k];
        }

        // Choice 1: Skip current interval
        Result skip = solve(i + 1, k);

        // Choice 2: Take current interval

        Interval current = arr[i];

        int next = findNext(i + 1, current.end);

        Result nextResult = solve(next, k - 1);

        long takeWeight = current.weight + nextResult.weight;

        List<Integer> takeIndices = new ArrayList<>();

        takeIndices.add(current.index);

        takeIndices.addAll(nextResult.indices);

        Collections.sort(takeIndices);

        Result take = new Result(takeWeight, takeIndices);

        // Compare both choices
        Result best;

        if (take.weight > skip.weight) {
            best = take;
        } 
        else if (take.weight < skip.weight) {
            best = skip;
        } 
        else {

            if (compare(take.indices, skip.indices) < 0) {
                best = take;
            } 
            else {
                best = skip;
            }
        }

        dp[i][k] = best;

        return best;
    }

    private int findNext(int startIndex, int end) {

        int left = startIndex;
        int right = arr.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid].start > end) {
                right = mid;
            } 
            else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int compare(List<Integer> a, List<Integer> b) {

        int n = Math.min(a.size(), b.size());

        for (int i = 0; i < n; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return Integer.compare(a.get(i), b.get(i));
            }
        }

        return Integer.compare(a.size(), b.size());
    }
}