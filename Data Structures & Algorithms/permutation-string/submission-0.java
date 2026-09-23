class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] ref = new int[26];
        for(int i =0; i < s1.length(); i++){
            ref[s1.charAt(i) - 'a']++;
        }

        int[] window = new int[26];

        for(int r = 0; r < s1.length(); r++){
            window[s2.charAt(r) - 'a']++;
        }

        // check if they are equal 
        if(Arrays.equals(ref, window)) return true;
        
        int l = 0;
        for(int r = s1.length(); r < s2.length(); r++){
            window[s2.charAt(l) - 'a']--;
            l++;
            window[s2.charAt(r) - 'a']++;

            if(Arrays.equals(ref, window)) return true;
        }

        return false;
    }
}
