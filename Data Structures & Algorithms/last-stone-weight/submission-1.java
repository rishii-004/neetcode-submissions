class Solution {
    public int lastStoneWeight(int[] stones) {
        
        if(stones.length == 1) return stones[0];
        if(stones.length == 2) return Math.abs(stones[0] - stones[1]);


       Arrays.sort(stones);
       int n = stones.length - 1;
       int one = stones[n];
       for(int i = n-1; i >= 0; i-- ){
            int diff = Math.abs(one - stones[i]);
            one = diff;
       }
       return one;
    }
}
