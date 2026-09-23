class Solution {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        if(s.length() != t.length()) return false;

        for(int i =0; i < s.length(); i++){
            char ch = s.charAt(i);
            int ind = ch - 'a';
            arr[ind]++;

            char ch2 = t.charAt(i);
            int ind2 = ch2 - 'a';
            arr[ind2]--;
        }

        for(int i = 0; i < arr.length; i++){
           if(arr[i] != 0) return false;
        }

        return true;
    }
}
