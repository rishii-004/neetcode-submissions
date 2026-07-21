class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxWater = 0;

        while (left < right) {
            int width = right - left;
            int height = Math.min(heights[left], heights[right]);

            int area = width * height;
            maxWater = Math.max(maxWater, area);

            // Move the smaller wall
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}