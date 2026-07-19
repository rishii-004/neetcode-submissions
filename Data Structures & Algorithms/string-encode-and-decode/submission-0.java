class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for(String str : strs){
            res.append(str.length()).append("#").append(str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i = 0; 

        while(i < str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            // extract length 
            int length = Integer.parseInt(str.substring(i, j));
            j++;
            ans.add(str.substring(j, j + length));

            i = j + length;
        }
        return ans;
    }
}
