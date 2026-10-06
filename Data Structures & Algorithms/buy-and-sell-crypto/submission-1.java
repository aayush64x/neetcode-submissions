class Solution {
    public int maxProfit(int[] prices) {
        int max = 0; 
        int start = 0; 
        int end = start + 1; 
        while(end < prices.length){
            if(prices[start] > prices[end]){
                start = end; 
                continue; 
            }
            int profit = prices[end] - prices[start];
            max = Math.max(max, profit);
            end++;
        }
        return max;  
    }
}
