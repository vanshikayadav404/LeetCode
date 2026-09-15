class Solution {
    public int maxPalindromes(String s, int k) {

        int n = s.length();

        boolean[][] pal = new boolean[n][n];

        // Step 1: Find all palindromes
        for (int len = 1; len <= n; len++) {

            for (int i = 0; i + len <= n; i++) {

                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {

                    if (len <= 2) {
                        pal[i][j] = true;
                    } 
                    else {
                        pal[i][j] = pal[i + 1][j - 1];
                    }
                }
            }
        }

        // Step 2: DP
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {

            // Option 1: Skip current character
            dp[i] = dp[i - 1];

            // Option 2: Take palindrome ending at i-1
            for (int start = 0; start < i; start++) {

                int len = i - start;

                if (len >= k && pal[start][i - 1]) {

                    dp[i] = Math.max(
                        dp[i],
                        dp[start] + 1
                    );
                }
            }
        }

        return dp[n];
    }
}
