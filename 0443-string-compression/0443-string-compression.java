class Solution {
    public int compress(char[] chars) {
        String str = new String(chars);
        String s = "";
        for(int i=0; i<str.length(); i++){
            Integer count = 1;   //int
            while(i< str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                count++;
                i++;
            }
            s = s + str.charAt(i);
            if(count > 1){
                s = s + count.toString(); //String.valueOf(count);
            }
        }
        for(int i=0; i<s.length(); i++){
            chars[i] = s.charAt(i);
        }
        return s.length();
    }
}