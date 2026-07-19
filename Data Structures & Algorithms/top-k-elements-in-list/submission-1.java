class Solution {

    static class Pair {
        int element;
        int frequency;

        Pair(int element, int frequency) {
            this.element = element;
            this.frequency = frequency;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Pair> minHeap = new PriorityQueue<>(
            (a, b) -> a.frequency - b.frequency
        );

        // Step 3: Keep only k most frequent elements
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {

            minHeap.offer(new Pair(
                entry.getKey(),
                entry.getValue()
            ));

            // Remove least frequent element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Step 4: Extract result
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll().element;
        }

        return result;
    }
}