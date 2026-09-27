class Solution {
    public String reverseParentheses(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == ')') {
                int j = result.length() - 1;

                while (j >= 0 && result.charAt(j) != '(') {
                    j--;
                }

                int left = j + 1;
                int right = result.length() - 1;

                while (left < right) {
                    char temp = result.charAt(left);
                    result.setCharAt(left, result.charAt(right));
                    result.setCharAt(right, temp);

                    left++;
                    right--;
                }

                result.deleteCharAt(j);
            } 
            else {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}