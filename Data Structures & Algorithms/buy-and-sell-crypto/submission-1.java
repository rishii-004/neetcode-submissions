class Solution {
    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        if(prices.length == 1) return 0;

        int buy = prices[0];
        for(int i =1 ; i < prices.length; i++){
            if(prices[i] < buy) buy = prices[i];
            int profit = prices[i] - buy;
            max = Math.max(profit, max);
        }
        return max;
    }
}
