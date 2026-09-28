class Solution {
    public int lastStoneWeight(int[] stones) {
        int one = stones[0];
        int two;
        int ans;
        for(int i=1; i < stones.length; i++){
            two = stones[i];
            int diff = Math.abs(two-one);
            ans = diff;
            one = diff;
        }
        return one;
    }
}
