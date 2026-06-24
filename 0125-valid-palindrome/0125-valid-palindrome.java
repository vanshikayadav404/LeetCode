class Solution {
    public boolean isPalindrome(String s) {

        String cleaned = "";

        for (int i = 0; i < s.length(); i++) {
            char ch = Character.toLowerCase(s.charAt(i));

            if (Character.isLetterOrDigit(ch)) {
                cleaned += ch;
            }
        }

        String rev = "";

        for (int i = cleaned.length() - 1; i >= 0; i--) {
            rev += cleaned.charAt(i);
        }

        return cleaned.equals(rev);
    }
}