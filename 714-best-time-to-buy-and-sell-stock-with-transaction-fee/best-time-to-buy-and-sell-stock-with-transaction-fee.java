class Solution {
    public int maxProfit(int[] prices, int fee) {
        //so 
        //buy = 1 means we can buy 
        //buy = 0 we are holding stk sell it first

        int n = prices.length;
        int[][] dp = new int[n+1][2];

        //  if (i == n)return 0;
         dp[n][0] = 0;
         dp[n][1] = 0;
        
        for(int i = n-1 ; i>=0 ; i--){
            for (int buy = 0; buy < 2; buy++){
                int profit =0;
                if(buy == 1){
                   //deciding buy
                   //profit = max(you buy +you not buy)
                   profit = Math.max(-prices[i]+dp[i+1][0],
                                        0 + dp[i+1][1]); 
                }else{
                    //deciding sell
                    //profit = max(sell,not sell)
                    //here in sell case --> when you are complete one transaction you need to subtract the fee from profit
                    profit = Math.max(-fee + prices[i]+dp[i+1][1],
                                     0+dp[i+1][0]);
                }

              dp[i][buy] = profit;
            }
        }
        
        //we have infinite transaction we can buy ans sell as much time as we want
        //i,buy,prices arr ,arr lengtth,fee,dp
        return dp[0][1];
    }
}