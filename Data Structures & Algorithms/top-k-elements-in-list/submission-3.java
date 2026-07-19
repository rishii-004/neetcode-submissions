class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count frequencies
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create buckets
        // Index = frequency
        List<Integer>[] buckets = new List[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int frequency = entry.getValue();
            int element = entry.getKey();

            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }

            buckets[frequency].add(element);
        }

        // Step 3: Collect top k elements
        int[] result = new int[k];
        int index = 0;

        for (int frequency = buckets.length - 1;
             frequency >= 0 && index < k;
             frequency--) {

            if (buckets[frequency] != null) {

                for (int element : buckets[frequency]) {
                    result[index++] = element;

                    if (index == k) {
                        break;
                    }
                }
            }
        }

        return result;
    }
}