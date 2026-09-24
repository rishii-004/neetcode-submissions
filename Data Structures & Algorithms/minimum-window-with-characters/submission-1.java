class Solution {
    public String minWindow(String s, String t) {

        int[] need = new int[52];
        int required = 0;

        // Build frequency map for t
        for (char c : t.toCharArray()) {
            int idx = getIndex(c);

            if (need[idx] == 0) {
                required++;
            }

            need[idx]++;
        }

        int[] window = new int[52];

        int have = 0;
        int l = 0;

        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        for (int r = 0; r < s.length(); r++) {

            // Add s[r]
            int idx = getIndex(s.charAt(r));
            window[idx]++;

            // We just satisfied this character's requirement
            if (window[idx] == need[idx]) {
                have++;
            }

            // Current window is valid
            while (have == required) {

                // Record this window if it is smaller
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    minStart = l;
                }

                // Remove s[l]
                int leftIdx = getIndex(s.charAt(l));
                window[leftIdx]--;

                // We no longer have enough of this character
                if (window[leftIdx] < need[leftIdx]) {
                    have--;
                }

                l++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(minStart, minStart + minLen);
    }

    private int getIndex(char c) {
        if (c >= 'A' && c <= 'Z') {
            return c - 'A';
        }

        return 26 + (c - 'a');
    }
}


// length of s >= t
// create a hashmap for freq, the map of s should have all of the entries map of t has 
// there can be more entries as well, 


