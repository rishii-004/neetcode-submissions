class Solution {
    class Pair {
        int val;
        int ind;
        public Pair(int val, int ind) {
            this.val = val;
            this.ind = ind;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];

        PriorityQueue<Pair> maxheap = new PriorityQueue<>((a, b) -> Integer.compare(b.val, a.val));

        for (int i = 0; i < k; i++) {
            maxheap.offer(new Pair(nums[i], i));
        }

        ans[0] = maxheap.peek().val;

        int l = 0;
        int idx = 1;

        for (int r = k; r < nums.length; r++) {
            maxheap.offer(new Pair(nums[r], r));
            l++;

            while (maxheap.peek().ind < l) {
                maxheap.poll();
            }

            ans[idx++] = maxheap.peek().val;
        }

        return ans;
    }
}
