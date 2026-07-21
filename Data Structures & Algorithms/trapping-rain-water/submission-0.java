class Solution {
    public int trap(int[] height) {
        int n = height.length;

        if (n <= 2)
            return 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int water = 0;

        for (int i = 1; i < n - 1; i++) {
            int level = Math.min(leftMax[i], rightMax[i]);
            water += level - height[i];
        }

        return water;
    }
}

/*

    first find for each element, what is the next largest element on both left and right, then you
   will take the min of the left and right, this will give you something, now from this you will
   subtract the height at that index, this will give you the amount of water that can be trapped for
   that particular index, you will do this throughout the array one thing to keep in mind the edge
   cases, the start and the end of the array cannot store any water


*/