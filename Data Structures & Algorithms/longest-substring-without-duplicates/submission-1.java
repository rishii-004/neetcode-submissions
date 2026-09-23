class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0;
        int max = 0;
        for(int r = 0; r < s.length(); r++){
            char elt = s.charAt(r);
            while(set.contains(elt)){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(elt);
            int len = r - l + 1;
            max = Math.max(max, len);
        }
        return max;
    }
}
