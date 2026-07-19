class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String sorted = helper(strs[i]);

            if(map.containsKey(sorted)){
                // update the list
                map.get(sorted).add(strs[i]);
            }else{
                // add new list 
                map.put(sorted, new ArrayList<>());
                map.get(sorted).add(strs[i]);
            }
        }

        return new ArrayList<>(map.values());
    }

    public String helper(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}

/*
    create a hashmap<string, list<string>>
    for every string, first sort and check in the map 
    if yes, then modify the list 
    if not present then add a new entry into the map 

        String s = "dcba";
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
*/