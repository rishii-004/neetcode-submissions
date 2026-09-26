class Solution {
    public int appendCharacters(String s, String t) {

        int ind = 0;
        for(int i =0; i < s.length(); i++){
            if(s.charAt(i) == t.charAt(ind)) ind++;
            if(ind == t.length()) return 0; 
        }

        return t.length() - ind ;
    }
}