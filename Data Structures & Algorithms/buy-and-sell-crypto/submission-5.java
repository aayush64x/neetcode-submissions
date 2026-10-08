class Solution {
    public int maxProfit(int[] prices) {
        int max = 0; 
        int cheapest = prices[0];
        for(int i = 0; i<prices.length; i++){
            if(prices[i] < cheapest ){
                cheapest = prices[i];
            }
            else{
                int profit = prices[i] - cheapest;
                max = Math.max(max, profit);
            }
            
        }
        return max; 
    }
}
