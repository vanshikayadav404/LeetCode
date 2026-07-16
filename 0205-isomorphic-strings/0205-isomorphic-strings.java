class Solution {
    public boolean isIsomorphic(String s, String t) {

        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if (mapST.containsKey(ch1)) {

                if (mapST.get(ch1) != ch2)
                    return false;

            } else {

                if (mapTS.containsKey(ch2))
                    return false;

                mapST.put(ch1, ch2);
                mapTS.put(ch2, ch1);
            }
        }

        return true;
    }
}