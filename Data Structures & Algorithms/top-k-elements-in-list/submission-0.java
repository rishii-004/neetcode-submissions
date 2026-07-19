class Solution {
    class Pair {
        int x; 
        int y;

        public Pair(int a, int b) {
            this.x = a;
            this.y = b;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequencies
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Create max heap based on frequency
        PriorityQueue<Pair> maxheap = new PriorityQueue<>(
            (a, b) -> b.y - a.y
        );

        // Add all elements to heap
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxheap.offer(new Pair(
                entry.getKey(),
                entry.getValue()
            ));
        }

        // Extract k most frequent elements
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = maxheap.poll().x;
        }

        return result;
    }
}

/*
maxheap version - put all the pairs (elt, freq) into the heap 
poll only the k items
*/