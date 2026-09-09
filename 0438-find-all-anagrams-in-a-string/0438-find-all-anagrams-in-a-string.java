class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length()) {
            return list;
        }
        int k = p.length();
        int l = 0;
        int r = 0;
        int[] freqp = new int[128];
        int[] freqs = new int[128];
        while (r < k) {
            freqp[p.charAt(r)]++;
            freqs[s.charAt(r)]++;
            r++;
        }
        if (Arrays.equals(freqp, freqs)) {
            list.add(l);
        }
        while (r < s.length()) {
            freqs[s.charAt(r)]++;
            freqs[s.charAt(l)]--;
            l++;
            r++;
            if (Arrays.equals(freqp, freqs)) {
                list.add(l);
            }
        }
        return list;
    }
}