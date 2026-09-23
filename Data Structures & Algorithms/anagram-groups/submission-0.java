class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            int[] arr = new int[26];

            for(int j = 0; j < strs[i].length(); j++){
                arr[strs[i].charAt(j) - 'a']++;
            }

            // convert the array to a string key 
            String key = Arrays.toString(arr);

            if(map.containsKey(key) == false){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }

        return new ArrayList<>(map.values());

    }
}
