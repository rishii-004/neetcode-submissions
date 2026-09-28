class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxheap = new PriorityQueue<>(
            (a, b) -> b - a
        );

        for (int stone : stones) {
            maxheap.offer(stone);
        }

        while (maxheap.size() > 1) {
            int one = maxheap.poll();
            int two = maxheap.poll();

            if (one != two) {
                maxheap.offer(one - two);
            }
        }

        return maxheap.isEmpty() ? 0 : maxheap.poll();
    }
}
