class Solution {

    class Pair {
        int dist;
        int[] arr;

        public Pair(int dist, int[] arr) {
            this.dist = dist;
            this.arr = arr;
        }
    }

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Pair> maxheap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.dist, a.dist)
        );

        for (int[] arr : points) {

            int x = arr[0];
            int y = arr[1];

            int dist = x * x + y * y;

            Pair pair = new Pair(dist, arr);
            maxheap.offer(pair);

            if (maxheap.size() > k) {
                maxheap.poll();
            }
        }

        int[][] ans = new int[k][2];
        int ind = 0;

        while (!maxheap.isEmpty()) {
            Pair p = maxheap.poll();

            ans[ind][0] = p.arr[0];
            ans[ind][1] = p.arr[1];

            ind++;
        }

        return ans;
    }
}
