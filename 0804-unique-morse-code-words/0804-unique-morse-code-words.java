class Solution {
    public int uniqueMorseRepresentations(String[] words) {
          String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",
            ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
            "...","-","..-","...-",".--","-..-","-.--","--.."};

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            String code = "";
            for (int j = 0; j < words[i].length(); j++) {
                char ch = words[i].charAt(j);
                code += morse[ch - 'a'];
            }
            set.add(code);
        }
        return set.size();
    }
}