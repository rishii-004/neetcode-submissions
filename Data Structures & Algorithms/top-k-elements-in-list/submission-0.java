class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        // ind - freq and list - elts 
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            int elt = e.getKey();
            int freq = e.getValue();
            if(buckets[freq] == null) buckets[freq] = new ArrayList<>();
            buckets[freq].add(elt);
        }

        int n = buckets.length;
        int index = 0;
        int[] ans = new int[k];

        for(int i = n-1; i >= 0; i--){
            if(buckets[i] != null && index < k){
                for(Integer elt : buckets[i]){
                    ans[index] = elt;
                    index++;

                    if(index >= k ) break;
                }
            }
        }   

        return ans;
    }
}


// the challenge is to efficiently sort the values in the hashmap, 
// we can use heap which will have the heapify function for logn and there are k elts so o(klogn) but this can be trimmed down furthur 
// for this we use bucket sort where we use a array of lists again, indices are frequencies (0, n) and store all the elts in the indx 















