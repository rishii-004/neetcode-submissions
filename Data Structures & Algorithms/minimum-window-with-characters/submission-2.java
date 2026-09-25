class Solution {
    public String minWindow(String s, String t) {
        int[] map1 = new int[52];
        int[] map2 = new int[52];
        int need = 0;
        int have = 0;

        for(char ch : t.toCharArray()){
            int ind = getind(ch);
            if(map1[ind] == 0) need++;
            map1[ind]++;
        }

        int l =0;
        int minlength = Integer.MAX_VALUE;
        int minstart =0;

        for(int r = 0; r < s.length(); r++){
            int ind = getind(s.charAt(r));
            map2[ind]++;
            if(map2[ind] == map1[ind]) have++;

            while(have == need){
                if(r - l + 1 < minlength){
                    minlength = r - l + 1;
                    minstart = l;
                }
                int leftind = getind(s.charAt(l));
                map2[leftind]--;
                if(map2[leftind] < map1[leftind]){
                    have--;
                }
                l++;
            }
        }

        if(minlength == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(minstart, minstart + minlength);

    }
    public int getind(char ch){
        if(ch >= 'A' && ch <= 'Z'){
            return ch - 'A';
        }
        return 26 + (ch - 'a');
    }
}
