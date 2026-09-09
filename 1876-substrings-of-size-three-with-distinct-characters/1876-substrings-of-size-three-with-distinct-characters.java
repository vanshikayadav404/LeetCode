class Solution {
    public int countGoodSubstrings(String s) {
        int res=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String ss=s.substring(i,j+1);
                if (j-i+1==3) {
                    if (ss.charAt(0) != ss.charAt(1) &&
                        ss.charAt(1) != ss.charAt(2) &&
                        ss.charAt(0) != ss.charAt(2)){
                        res++;
                        }
                }
            }
        }
        return res;
    }
}