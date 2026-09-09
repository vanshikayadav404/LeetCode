class Solution {
    public int maxVowels(String s, int k) {

        int left = 0;
        int right = 0;
        int count = 0;
        int max = 0;

        while (right < s.length()) {

            if (isVowel(s.charAt(right))) {
                count++;
            }

            right++;

            while (right - left > k) {

                if (isVowel(s.charAt(left))) {
                    count--;
                }

                left++;
            }

            if (right - left == k) {
                max = Math.max(max, count);
            }
        }

        return max;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' ||
               c == 'o' || c == 'u';
    }
}