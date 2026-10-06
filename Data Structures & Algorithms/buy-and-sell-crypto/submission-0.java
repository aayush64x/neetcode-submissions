class Solution {
    public int maxProfit(int[] prices) {
        int max = 0; 
        int start = 0; 
        int end = prices.length; 
        while(start < end){
            for(int i = start + 1; i< end; i++){
                int profit = prices[i] - prices[start];
                max = Math.max(profit, max);
            }
            start++; 
        }
        return max;  
    }
}
