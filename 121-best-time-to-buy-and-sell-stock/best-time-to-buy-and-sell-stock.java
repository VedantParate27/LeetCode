class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int buy = 0;
        int sell = 1;
        
        while(sell < prices.length){
            if(prices[buy] < prices[sell])
                max = Math.max(max, prices[sell] - prices[buy]);
            
            else
                buy = sell;

            sell++;
        }

        return max;
    }
}