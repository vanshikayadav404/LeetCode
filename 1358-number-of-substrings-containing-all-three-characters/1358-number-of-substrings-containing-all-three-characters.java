class Solution {
    public int numberOfSubstrings(String s) {

        int[] freq = new int[3];
        int left = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) 
        {

            // Add current character
            freq[s.charAt(right) - 'a']++;

            // If window has a, b and c
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) 
            {

                // Count all valid substrings
                ans += s.length() - right;

                // Remove left character
                freq[s.charAt(left) - 'a']--;

                // Move left
                left++;
            }
        }

        return ans;
    }
}