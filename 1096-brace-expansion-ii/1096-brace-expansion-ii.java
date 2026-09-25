import java.util.*;

class Solution {

    String s;
    int i;

    public List<String> braceExpansionII(String expression) {
        s = expression;
        i = 0;

        Set<String> result = parseExpression();

        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);

        return ans;
    }

    // Handles UNION (,)
    Set<String> parseExpression() {

        Set<String> result = parseTerm();

        while (i < s.length() && s.charAt(i) == ',') {
            i++; // skip ','

            Set<String> next = parseTerm();

            result.addAll(next);
        }

        return result;
    }

    // Handles CONCATENATION
    Set<String> parseTerm() {

        Set<String> result = new HashSet<>();
        result.add("");

        while (i < s.length() && s.charAt(i) != '}' && s.charAt(i) != ',') {

            Set<String> next;

            if (s.charAt(i) == '{') {
                i++; // skip '{'

                next = parseExpression();

                i++; // skip '}'
            } 
            else {
                String word = "";

                while (i < s.length() &&
                       Character.isLetter(s.charAt(i))) {

                    word += s.charAt(i);
                    i++;
                }

                next = new HashSet<>();
                next.add(word);
            }

            // Cartesian product
            Set<String> temp = new HashSet<>();

            for (String a : result) {
                for (String b : next) {
                    temp.add(a + b);
                }
            }

            result = temp;
        }

        return result;
    }
}